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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/login")
@Api(value = "/login",description = "登录模块")
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

            //redisUtil.expire("demo",expiration,TimeUnit.MILLISECONDS); 未知原因方法失效


            redisUtil.set(admin.getUsername(),token,expiration,TimeUnit.MILLISECONDS);
            return new ResponseJson(200,"响应成功",token);
        }
        return new ResponseJson(false,"账号或者密码不对");
    }



}
