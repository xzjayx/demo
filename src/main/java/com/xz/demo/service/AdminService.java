package com.xz.demo.service;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.xz.demo.dao.AdminMapper;
import com.xz.demo.model.pojo.Admin;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class AdminService {

    @Autowired
    private AdminMapper mapper;

    private static ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
            new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());



    @Transactional(readOnly = true,rollbackFor = Exception.class)
    public Admin selectOne(Admin admin){
        return mapper.selectOne(admin);
    }



    public Workbook exportExcel(){

        executorService.schedule(() -> {
            //执行你的推送代码()
            System.out.println("推送");
        }, 60, TimeUnit.SECONDS);



        //使用easy poi注解导出 excel 更多注解类容详见官网
        List<Admin> admin = mapper.findAll(new Admin());
        return ExcelExportUtil.exportExcel(new ExportParams("测试", "表格"), Admin.class, admin);
    }
}
