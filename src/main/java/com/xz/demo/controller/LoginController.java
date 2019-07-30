package com.xz.demo.controller;


import com.xz.demo.config.Constant;
import com.xz.demo.config.ResponseJson;
import com.xz.demo.model.pojo.Admin;
import com.xz.demo.service.AdminService;
import com.xz.demo.util.JwtUtil;
import com.xz.demo.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 登录的模块
 * @author xz
 * */
@RestController
@RequestMapping("/login")
@Api(value = "/login",tags = "登录模块")
public class LoginController {


    private final AdminService adminService;

    private final RedisUtil redisUtil;

    @Autowired
    public LoginController(AdminService adminService, RedisUtil redisUtil){
        this.adminService = adminService;
        this.redisUtil = redisUtil;
    }


    @Value("${jwt.expiration}")
    private Long expiration;

    @ApiOperation(value = "登录", notes = "返回登录当前用户的相关信息")
    @PostMapping(value = "/login")
    public ResponseJson login(
            @ApiParam(value = "登录表对象", required = true)
            @RequestBody Admin admin){
        Admin s = adminService.selectOne(admin);
        if(Objects.nonNull(s)){
            // 通过用户关联角色权限等，之后再完善
            String token = JwtUtil.createJWT(String.valueOf(s.getId()), admin.getUsername(), null, Constant.Redis.OSP_TEACHER_TIMEOUT*1000);




            redisUtil.set(admin.getUsername(),token,expiration,TimeUnit.MILLISECONDS);
            return new ResponseJson(200,"响应成功",token);
        }
        return new ResponseJson(false,"账号或者密码不对");
    }







    @PostMapping("exportExcel")
    @ApiOperation(value = "导出excel用户测试", notes = "返回一个excel")
    public void exportAssetsStockExcel(HttpServletResponse response){
        //告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=Excel.xls");
        try (ServletOutputStream s = response.getOutputStream()) {
            Workbook workbook = adminService.exportExcel();
            workbook.write(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
