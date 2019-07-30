package com.xz.demo.util;

import com.xz.demo.model.pojo.Admin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        List<Admin> admins = Arrays.asList(new Admin("张三", 18),
                new Admin("李四", 19),
                new Admin("王五", 20),
                new Admin("赵六", 223),
                new Admin("周七", 24),
                new Admin("王八", 29)
        );

        //stream的相关测试demo
    }
}
