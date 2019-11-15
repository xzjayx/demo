package com.xz.demo.util.string;



/**
 *  intern()；方法的解析
 *
 *判断这个常量是否存在于常量池。
 *   如果存在
 *    判断存在内容是引用还是常量，
 *     如果是引用，
 *      返回引用地址指向堆空间对象，
 *     如果是常量，
 *      直接返回常量池常量
 *   如果不存在，
 *    将当前对象引用复制到常量池,并且返回的是当前对象的引用
 *
 *
 * */
public class Test01 {


    public static void main(String[] args){
        String s1 = new String("1")+new String("23");
        s1.intern();
        String s2 = "123";
        System.out.println( s1 == s2);

        System.identityHashCode(s1);
    }
}
