package com.xz.demo.util;

import com.alibaba.fastjson.JSONObject;
import com.xz.demo.config.general.RestTemplateConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class RestUtil {


      private final static ApplicationContext applicationContext =  new AnnotationConfigApplicationContext(RestTemplateConfig.class);


    public static void main(String[] args){

        RestTemplate restTemplate = (RestTemplate) applicationContext.getBean("restTemplate");
       /* String url="https://way.jd.com/huoxin/here?lat=${lat}&lng=${lng}&cst=${cst}&appkey=${appkey}";
        Map<String, Object> params = new HashMap<>(16);
        params.put("lat", "39.9928");
        params.put("lng", "116.3961");
        params.put("cst", "1");
        params.put("appkey", "9f4abdb1bc5a25bfd8bb82afa8cf60f3");
        JSONObject data = restTemplate.getForObject(url, JSONObject.class, params);
        System.out.println(data);*/

        String url = "http://192.168.10.56:8080/test/demo/{id}";
        String data = restTemplate.getForObject(url, String.class,"36666" );
        System.out.println(data);

        //如果需要访问post请求 则可以参考blog  https://blog.csdn.net/qq_27130997/article/details/81625845 ，https://blog.csdn.net/zai_xia/article/details/80926157
    }
}
