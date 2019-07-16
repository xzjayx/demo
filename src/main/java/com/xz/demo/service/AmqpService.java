package com.xz.demo.service;




import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmqpService{

    @Autowired
    private AmqpTemplate amqpTemplate;


    public void convertAndSend() {
        String message = "为了测试简单写死";
        amqpTemplate.convertAndSend("com.xz.demo.rabbit", message);
    }
}
