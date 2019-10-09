package com.xz.demo.util;



public class TestBreak {



    public static void main(String[] args) {
        //打印1 -150 之间的质数 （质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数；否则称为合数。）
        for (int i = 2; i <150 ; i++) {
            boolean  zhishu = false;
            for (int j = 2; j < i-1; j++) {
                if(i%j == 0){
                    zhishu = true;
                    break;
                }
            }
            if(!zhishu){
                System.out.println(i);
            }
        }
    }
}
