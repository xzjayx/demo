package com.xz.demo.util;

import cn.hutool.core.collection.CollectionUtil;
import com.xz.demo.model.pojo.Admin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/**
 *
 *
 * 首先对stream的操作可以分为两类，中间操作(intermediate operations)和结束操作(terminal operations):
 *
 * 中间操作总是会惰式执行，调用中间操作只会生成一个标记了该操作的新stream。
 * 结束操作会触发实际计算，计算发生时会把所有中间操作积攒的操作以pipeline的方式执行，这样可以减少迭代次数。计算完成之后stream就会失效。
 * 虽然大部分情况下stream是容器调用Collection.stream()方法得到的，但stream和collections有以下不同：
 *
 * 无存储。stream不是一种数据结构，它只是某种数据源的一个视图，数据源可以是一个数组，Java容器或I/O channel等。
 * 为函数式编程而生。对stream的任何修改都不会修改背后的数据源，比如对stream执行过滤操作并不会删除被过滤的元素，而是会产生一个不包含被过滤元素的新stream。
 * 惰式执行。stream上的操作并不会立即执行，只有等到用户真正需要结果的时候才会执行。
 * 可消费性。stream只能被“消费”一次，一旦遍历过就会失效，就像容器的迭代器那样，想要再次遍历必须重新生成。
 *
 *
 * @author xz*/
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
       // admins.forEach(System.out::println);

        //sorted() 使用该方法排序数据 如果想到得到它 .默认是升序，但是如果逻辑要使用降序 需要reversed() 方法
        admins.stream().sorted(Comparator.comparing(Admin::getStatus).reversed()).forEach(x -> System.out.println(x.toString()));





    }
}
