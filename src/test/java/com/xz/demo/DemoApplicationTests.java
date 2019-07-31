package com.xz.demo;


import com.xz.demo.config.general.RestTemplateConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    final  ApplicationContext applicationContext =  new AnnotationConfigApplicationContext(RestTemplateConfig.class);


    @Test
    public void contextLoads() {
        // 根据某一个类型去获取它所有的bean
        //String[] names = applicationContext.getBeanNamesForType(RestTemplate.class);
        //获取默认的所有bean的名称
        //String[] names = applicationContext.getBeanDefinitionNames();
        RestTemplate restTemplate = (RestTemplate) applicationContext.getBean("restTemplate");
        //运用这个bean 去调用 get请求



    }

}
