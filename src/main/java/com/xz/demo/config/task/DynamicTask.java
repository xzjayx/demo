package com.xz.demo.config.task;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import com.xz.demo.service.TaskService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

/**
 * @author xz
 */
@Component
public class DynamicTask {


    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(50);
        return taskScheduler;
    }


    private ScheduledFuture<?> future;

    /**
     * 此时不能通过构造方法依赖 ，不然会产生循环依赖，构造方法会依赖初始化两次该类
     */
    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;


    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }



    public void startCron(Runnable runnable,String cron) {
        future = threadPoolTaskScheduler.schedule(runnable, new CronTrigger(cron.trim()));
        System.out.println("启动成功");
    }


    public void stopCron() {
        if (future != null) {
            future.cancel(true);
        }
    }


    public void reStartCron(Runnable runnable,String cron) {
        stopCron();// 先停止，在开启.
        future = threadPoolTaskScheduler.schedule(runnable, new CronTrigger(cron));

    }



}