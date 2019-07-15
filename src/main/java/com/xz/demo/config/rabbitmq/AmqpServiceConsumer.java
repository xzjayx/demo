package com.xz.demo.config.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AmqpServiceConsumer {

    private Logger logger = LoggerFactory.getLogger(AmqpServiceConsumer.class);

    @RabbitListener(queues = {"com.xz.demo.rabbit"})
    public void receiveSmsCodeQueue(String message) {
        this.logger.info("------hello：消费者处理消息------");
        this.logger.info("message==="+message);
    }

}
