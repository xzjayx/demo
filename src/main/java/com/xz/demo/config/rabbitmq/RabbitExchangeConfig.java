package com.xz.demo.config.rabbitmq;

import com.xz.demo.config.Constant;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author xz
 */
@Configuration
public class RabbitExchangeConfig {


    /**
     * Broker:它提供一种传输服务,它的角色就是维护一条从生产者到消费者的路线，保证数据能按照指定的方式进行传输,
     * Exchange：消息交换机,它指定消息按什么规则,路由到哪个队列。
     * Queue:消息的载体,每个消息都会被投到一个或多个队列。
     * Binding:绑定，它的作用就是把exchange和queue按照路由规则绑定起来.
     * Routing Key:路由关键字,exchange根据这个关键字进行消息投递。
     * v host:虚拟主机,一个broker里可以有多个v host，用作不同用户的权限分离。
     * Producer:消息生产者,就是投递消息的程序.
     * Consumer:消息消费者,就是接受消息的程序.
     * Channel:消息通道,在客户端的每个连接里,可建立多个channel.
     */

    private final RabbitAdmin rabbitAdmin;

    @Autowired
    public RabbitExchangeConfig(RabbitAdmin rabbitAdmin) {
        this.rabbitAdmin = rabbitAdmin;
    }


    /**
     * 针对消费者配置
     * 1. 设置交换机类型
     * 2. 将队列绑定到交换机
     FanoutExchange: 将消息分发到所有的绑定队列，无routing key的概念
     HeadersExchange ：通过添加属性key-value匹配
     DirectExchange:按照routing key分发到指定队列
     TopicExchange:多关键字匹配
     */


    @Bean
    FanoutExchange contractFanoutExchange() {
        FanoutExchange fanoutExchange = new FanoutExchange(Constant.rabbitMq.FANOUT_EXCHANGE_DEMO);
        this.rabbitAdmin.declareExchange(fanoutExchange);
        return fanoutExchange;
    }

    @Bean
    TopicExchange contractTopicExchangeDurable() {
        TopicExchange contractTopicExchange = new TopicExchange(Constant.rabbitMq.TOPIC_EXCHANGE_DEMO);
        this.rabbitAdmin.declareExchange(contractTopicExchange);
        return contractTopicExchange;
    }

    @Bean
    DirectExchange contractDirectExchange() {
        DirectExchange contractDirectExchange = new DirectExchange(Constant.rabbitMq.DIRECT_EXCHANGE_DEMO);
        this.rabbitAdmin.declareExchange(contractDirectExchange);
        return contractDirectExchange;
    }

    @Bean
    Queue getQueue() {
        Queue queue = new Queue(Constant.rabbitMq.QUEUE_DEMO, true);
        this.rabbitAdmin.declareQueue(queue);
        return queue;
    }

    /**
     * 绑定rabbitmq管道  DirectExchange:按照route key分发到指定队列
     */
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(getQueue()).to(contractDirectExchange()).with(Constant.rabbitMq.ROUTE_KEY_DEMO);
    }



}
