package com.xz.demo.service;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.xz.demo.dao.AdminMapper;
import com.xz.demo.model.pojo.Admin;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminMapper mapper;

    @Transactional(readOnly = true,rollbackFor = Exception.class)
    public Admin selectOne(Admin admin){
        return mapper.selectOne(admin);
    }



    public Workbook exportExcel(){
        //使用easy poi注解导出 excel 更多注解类容详见官网
        List<Admin> admin = mapper.findAll(new Admin());
        return ExcelExportUtil.exportExcel(new ExportParams("测试", "表格"), Admin.class, admin);
    }
}
