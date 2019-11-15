package com.xz.demo.util;

import com.xz.demo.config.Constant;
import com.xz.demo.config.general.RestTemplateConfig;
import com.xz.demo.model.pojo.Admin;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.OutputStream;

import static javafx.scene.input.KeyCode.L;

/**
 * java中hashcode和equals的区别和联系
 *  https://www.cnblogs.com/xiohao/p/4199446.html
 * @author xz
 */
public class Hashdemo {





    public static void main(String[] args) {

       /* AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RestTemplateConfig.class);

        Object bean1 = applicationContext.getBean("restTemplate");

        Object bean2 = applicationContext.getBean("restTemplate");

        System.out.println(bean1.equals(bean2));


        System.out.println("我\u2122\u005B要艹你啊，梁非凡");*/





        int num,num1;
        num =5;
        num1 = 5;


        double n = num + 3.14;

        System.out.println(n);        // 8.14

        // += -= *= /= %=   复合赋值运算符 隐藏了一个强制类型转换 一、例如 num+= 3.14  ==> （num的类型）（ num + 3.14）
        num1+= 3.14;

        System.out.println(num1);     //8



        short s =1;


        long p = 1;

        s += 1; // s = s+1



        short s1 = 127;


        int s2 = s+s1;


        //int s4 =  2147564124;
        float f= 1.2f ;


        char ch = 'a';
        int c1 = 'a';
        System.out.println(c1);
        int o = ch+1;
        System.out.println(o);

        char c = 'a'+1;
        System.out.println(c);

        int a = 10;
        int b = 20;
        System.out.println(a>b?3.014:1L);
    }


}
