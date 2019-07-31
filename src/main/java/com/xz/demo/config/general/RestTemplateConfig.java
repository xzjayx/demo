package com.xz.demo.config.general;

import com.xz.demo.model.pojo.Admin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author xz
 * 创建的bean 默认是单例的，单例的bean 会在applicationcontext 初始化的时候就会直接初始化 单例的bean ，多实例是调用的时候就用获取bean
 * 才会去创建。
 */
@Configuration
public class RestTemplateConfig {


    /**
     * 方法名为id
     * */
    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory){
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(15000);
        factory.setReadTimeout(5000);
        return factory;
    }
}
