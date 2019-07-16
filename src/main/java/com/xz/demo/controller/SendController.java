package com.xz.demo.controller;

import com.xz.demo.service.AmqpService;
import com.xz.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class SendController {

    private final AmqpService amqpService;

    private final RedisUtil redisUtil;

    @Autowired
    public SendController(AmqpService amqpService, RedisUtil redisUtil) {
        this.amqpService = amqpService;
        this.redisUtil = redisUtil;
    }

    @GetMapping("/send")
    public void sendMsg(){
        String message = "为了测试简单写死";
        amqpService.convertAndSend(message);
        System.out.println(redisUtil.hasKey("demo"));
    }

}
