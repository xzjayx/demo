package com.xz.demo.config.rabbitmq;

import com.xz.demo.config.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Message;
import com.rabbitmq.client.Channel;

import java.io.IOException;

/**
 * @author xz
 */
@Slf4j
@Component
public class MsgReceiver {



    /**
     * 一对一接收相关消息  如果一对多多写几个
     * */
    @RabbitListener(queues = Constant.rabbitMq.QUEUE_DEMO)
    public void getMsgA(String content,Channel channel, Message message) {
        log.info("A---------------： {}" , content);
        //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            //丢弃这条消息
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = Constant.rabbitMq.QUEUE_DEMO)
    public void getMsgB(String content,Channel channel, Message message) {
        log.info("B-----------------： {}" , content);
        //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            //丢弃这条消息
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = Constant.rabbitMq.QUEUE_DEMO)
    public void getMsgC(String content,Channel channel, Message message) {
        log.info("C-----------------： {}" , content);
        //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            //丢弃这条消息
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
            e.printStackTrace();
        }
    }



}
