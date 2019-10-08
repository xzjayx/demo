package com.xz.demo.util.calculate;

import java.util.Scanner;

/**
 * @author xz
 */
public class JieCheng {

    /**
     * 输入一个数，计算该数的阶乘
     * */
    public static void main(String[] args) {
       /* Scanner scanner = new Scanner(System.in);
        int anInt = scanner.nextInt();
        jieCheng(anInt);*/
        char zhifu = '1';
        System.out.println(zhifu + 3.0);
    }

    private static void jieCheng(int number){
        // 10  = 1 * 2 * 3 * 4 * 5 ... 10
        int result = 1;
        for (int i = 1; i < number; i++) {
            result =  result * (i+1);
        }
        System.out.println(result);
    }
}
