package com.xz.demo.controller;

import com.xz.demo.config.ResponseJson;
import com.xz.demo.config.rabbitmq.MsgProducer;
import com.xz.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiezhi
 */
@RestController
@RequestMapping("/send")
public class SendController {

    private final MsgProducer msgProducer;

    private final RedisUtil redisUtil;

    @Autowired
    public SendController(RedisUtil redisUtil, MsgProducer msgProducer) {

        this.redisUtil = redisUtil;
        this.msgProducer = msgProducer;
    }

    @GetMapping("/sendMsg")
    public ResponseJson sendMsg(){
        int msgNum = 100;
        for(int i=1;i<=msgNum;i++) {
            msgProducer.sendMsg("---------第------"+i+"次消息");
        }
       /* msgProducer.sendMsg("哈哈哈哈哈哈哈");
        System.out.println(redisUtil.hasKey("demo"));*/
        return new ResponseJson(true,"发送消息成功");
    }

}
