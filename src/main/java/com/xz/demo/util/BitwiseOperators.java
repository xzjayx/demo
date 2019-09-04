package com.xz.demo.util;

import com.xz.demo.model.pojo.Admin;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

/**
 * java 位运算符的详解
 * @author xz
 */
public class BitwiseOperators {


    /**
     *
     *  https://www.cnblogs.com/SunArmy/p/9837348.html
     *
     * Java位运算是针对于整型（byte、char、short、int、long）数据类型的二进制进行的移位操作。
     *
     * 与(&)、或(|)、异或(^)、取反(~)、左移(<<)、右移(>>)、无符号右移(>>>)
     * 位运算符主要是在二进制里面做运算的 则效率很高
     * */


    public static void main(String[] args) {

        int i =0;
        int tem = i++;
        System.out.println(tem);



       /*  4 ： 0000 0100         1 表示 true 0 表示false
        7 ： 0000 0111 */

       int a = 3, b=7;

       /*
       * 运算符 &  其实就是两个boolean之间的运算 全true(1),即为true(1)   全false(0),即为false(0)  一false(0)一true(1),还是false(0)
       * 场景1：判断奇偶数 a&1 结果为 0 ，a就是偶数 结果为 1 ，a就是奇数
       * */
        //oddEven(a);
        //Average(6,5);
        //change(1,2);
    }


    private static void oddEven(Integer num){
        if((num&1) == 0){
            System.out.println(num+"是偶数");
        }else{
            System.out.println(num+"是奇数");
        }
    }


    /**
     * 场景2：求平均数并且向下取整 (x&y)+((x^y)>>1) 比如 6 6 得出来6 ，6 和 5 得出来是 5
     * */

    private static void Average(Integer  x, Integer y){


       int average = (x&y)+((x^y)>>1);
        System.out.println(average);
    }


    /**
     * 异或 使用场景 不用第三方变量，交换x y 的值  x^=y 等价于 a = x = x^y  第二个 y^=x 等价于 y = y^x (此时x的值在被重新赋值过)
     * */
    private static void change(Integer  x, Integer y){
        x^= y; y ^= x; x ^= y;
        System.out.println(x);
        System.out.println(y);
    }

}
