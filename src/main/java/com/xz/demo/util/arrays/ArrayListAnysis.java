package com.xz.demo.util.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xz
 * ArrayList源码分析
 */
public class ArrayListAnysis {

    public static void main(String[] args) {
            List<Integer> list = new ArrayList<>();
            list.add(10);
            list.add(20);
            list.add(30);
            list.add(40);
            list.add(50);
            list.add(60);
            list.add(70);
            list.add(80);
        for (int i = 0; i <list.size() ; i++) {

        }


        /*for (Integer num:list
             ) {
            //list.remove(num);
        }*/
    }



   /* private static void j1(){
        long l = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>(16);
        list.add(1);
        System.out.println(System.currentTimeMillis()-l);
    }


    private static void j1(int i){
        long l = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(System.currentTimeMillis()-l);
    }*/
}
