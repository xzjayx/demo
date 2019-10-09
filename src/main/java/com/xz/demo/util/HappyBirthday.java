package com.xz.demo.util;

import com.google.common.collect.ImmutableList;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author xiezhi
 */
@Log4j2
public class HappyBirthday {


    /*
    * 强制类型转换  char 类型转换 byte short 都会损失精度，因为char 是没有符号位置，而 byte short 都有第一位是符号位，会损失精度
    * **/

    public static void main(String[] args) {
        char c = 65;

        byte b = (byte) c;

        short c1 = 65;

        char c2 = (char) c1;
        System.out.println(b+"------"+c2);
    }
}
