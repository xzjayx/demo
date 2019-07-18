package com.xz.demo.config.rabbitmq;

import com.xz.demo.config.Constant;
import com.xz.demo.config.general.SequenceId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息生产者bean
 * @author xz
 */
@Slf4j
@Component
public class MsgProducer implements RabbitTemplate.ConfirmCallback {



    private final RabbitTemplate rabbitTemplate;

    private final SequenceId sequenceId;

    @Autowired
    public MsgProducer(RabbitTemplate rabbitTemplate, SequenceId sequenceId) {
        this.rabbitTemplate = rabbitTemplate;
        this.sequenceId = sequenceId;
        //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
        rabbitTemplate.setConfirmCallback(this);
    }


    public void sendMsg(String content) {
        // CorrelationData  该数据的作用是给每条消息一个唯一的标识,因为绑定的交换机是 DirectExchange:按照routing key分发到指定队列
        CorrelationData correlationId = new CorrelationData(sequenceId.nextId());
        //把消息放入ROUTING KEY_A对应的队列当中去，对应的是队列A 所以需要routing key
        rabbitTemplate.convertAndSend(Constant.rabbitMq.DIRECT_EXCHANGE_DEMO, Constant.rabbitMq.ROUTE_KEY_DEMO, content, correlationId);
    }


    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info(" 回调id:" + correlationData);
        if (ack) {
            //消息确认ack机制
            log.info("消息成功被发送到rabbitmq");
        } else {
            log.info("消息发送到rabbitmq失败:" + cause);
        }
    }
}
