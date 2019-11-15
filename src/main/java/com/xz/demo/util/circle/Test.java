package com.xz.demo.util.circle;


public class Test {

    public static void main(String[] args) {
        Integer a1 = 127;
        Integer a2 = 127
                ;
        System.out.println(a1 == a2);
        Integer a = 1;
        add(a);
        System.out.println(a);
        StringBuffer sb = new StringBuffer("hello");
        add(sb);
        System.out.println(sb);
    }

    private static void add(Integer a){
        a = a+10;
    }
    private static void add(StringBuffer a){
        a = a.append("world");
    }

}
