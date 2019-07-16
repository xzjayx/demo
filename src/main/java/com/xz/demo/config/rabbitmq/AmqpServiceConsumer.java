package com.xz.demo.config.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AmqpServiceConsumer {



    @RabbitListener(queues = {"com.xz.demo.rabbit"})
    public void receiveSmsCodeQueue(String message) {
        log.info("------hello：消费者处理消息------");
        log.info("message==="+message);
    }

}
