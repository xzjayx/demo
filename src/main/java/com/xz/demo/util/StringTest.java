package com.xz.demo.util;


public class StringTest {

    /*public static void main(String[] args) {
       *//* String s = "123";
        String s1 = new String("123");

        System.out.println(s == s1);*//*

        int x = 10;
        int y = 12;
        System.out.println(y % x);

        System.out.println(Math.round(11.4));

    }*/

    static{
        int x=5;
    }
    static int x,y;
    public static void main(String args[]){
        x--;
        myMethod( );
        System.out.println(x+y+ ++x);
    }
    public static void myMethod( ){
        y=x++ + ++x; // y 0  x 1
    }
}
