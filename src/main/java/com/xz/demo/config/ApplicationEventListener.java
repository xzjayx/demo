package com.xz.demo.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * springboot的监听器
 * @author xz
 * */
/*@Component*/
public class ApplicationEventListener implements ApplicationListener {


    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(event);
    }
}
