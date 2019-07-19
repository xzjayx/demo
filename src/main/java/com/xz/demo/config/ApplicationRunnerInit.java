package com.xz.demo.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author xz
 */
@Component
public class ApplicationRunnerInit implements ApplicationRunner {

    /**
     *
     * run()主方法源码分析可得 最后才会加载
     *
     *所有CommandLineRunner/ApplicationRunner的执行时点是在SpringBoot应用的ApplicationContext完全初始化开始工作之后，
     * callRunners()可以看出是run方法内部最后一个调用的方法(可以认为是main方法执行完成之前最后一步)
     * - 只要存在于当前SpringBoot应用的ApplicationContext中的任何CommandLineRunner/ApplicationRunner，
     * 都会被加载执行(不管你是手动注册还是自动扫描去Ioc容器)
     *
     *
     * */

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("初始化再所有bean和配置加载之后,可以初始化相关redis的数据库字典配置等");
    }
}
