package com.xz.demo.config.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


import java.time.LocalDateTime;

/**
 * @author xz
 * 静态定时任务
 */
/*@Configuration
@EnableScheduling*/
public class StaticScheduleTask {

    /**
     * 或直接指定时间间隔，例如：5秒
     * //@Scheduled(fixedRate=5000)
     *
     * */
    @Scheduled(cron = "0/5 * * * * ?")
    private void configureTasks() {
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
    }
}
