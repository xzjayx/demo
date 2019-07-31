package com.xz.demo.util;

import com.xz.demo.config.general.RestTemplateConfig;
import com.xz.demo.model.pojo.Admin;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * java中hashcode和equals的区别和联系
 *  https://www.cnblogs.com/xiohao/p/4199446.html
 * @author xz
 */
public class Hashdemo {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RestTemplateConfig.class);

       /* Object bean1 = applicationContext.getBean("admin");

        Object bean2 = applicationContext.getBean("admin");

        System.out.println(bean1.equals(bean2));*/
    }


}
