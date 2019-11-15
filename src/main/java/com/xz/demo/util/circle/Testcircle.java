package com.xz.demo.util.circle;



/**
 * while 循环 for 循环 do-while 循环 打印 1-100 的和
 * @author xz
 */
public class Testcircle {

    public static void main(String[] args) {
        whileAdd();
        forAdd();
        doWhileAdd();
    }

    private static void whileAdd(){
        int i = 2;
        int resule = 1;
        while (i<=100){
            resule += i;
            i++;
        }
        System.out.println(resule);
    }

    private static void forAdd(){
        int result = 0;
        for (int i = 1; i <=100 ; i++) {
            result += i;
        }
        System.out.println(result);
    }

    private static void doWhileAdd(){
        int result = 0;
        int i = 1;
        do {
            result += i;
            i++;
        }while (i<=100);
        System.out.println(result);
    }
}
