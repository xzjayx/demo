package com.xz.demo.controller;

import com.xz.demo.config.ResponseJson;
import com.xz.demo.service.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xz
 */
@RestController
@RequestMapping("/email")
@Api(value = "/email",tags = "邮件模块")
public class EmailController {


    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @ApiOperation(value = "发送普通文本email", notes = "返回普通文本测试信息")
    @GetMapping("/sendText")
    public ResponseJson sendText(){
        for (int i = 0 ;i<= 5 ;i++){
            emailService.sendSimpleMail("1249446936@qq.com","吔屎啦，周谦","狗比天天不来上班");
        }
        return new ResponseJson(true,"响应成功");
    }

}
