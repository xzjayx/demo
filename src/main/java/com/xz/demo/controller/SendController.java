package com.xz.demo.controller;

import com.xz.demo.service.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class SendController {

    @Autowired
    private AmqpService amqpService;

    @GetMapping("/send")
    public void sendMsg(){
        String message = "为了测试简单写死";
        amqpService.convertAndSend(message);
    }

}
