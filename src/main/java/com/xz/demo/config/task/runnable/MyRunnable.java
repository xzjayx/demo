package com.xz.demo.config.task.runnable;

import java.util.Date;

/**
 * @author xz
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("DynamicTask.MyRunnable.run()" + new Date() + "-------------"+Thread.currentThread().getName());
    }
}
