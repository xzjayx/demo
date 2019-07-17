package com.xz.demo.config;

/**
 * @author xz
 */
public interface Constant {

    String JWT_SECRET="7786df7fc3a34e26a61c034d5ec8245d";

    String EXCEPTION_URL = "/exception/";


    interface rabbitMq{
        String FANOUT_EXCHANGE_DEMO = "fanout_exchange_demo";
        String TOPIC_EXCHANGE_DEMO = "topic_exchange_demo";
        String DIRECT_EXCHANGE_DEMO = "direct_exchange_demo";
        String QUEUE_DEMO = "queue_demo";
        String ROUTE_KEY_DEMO = "route_key_demo";
    }



    interface Redis {
        //admin的登录缓存超时时间
        int OSP_TEACHER_TIMEOUT = 3600;
    }


}
