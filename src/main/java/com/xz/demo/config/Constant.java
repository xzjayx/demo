package com.xz.demo.config;

public interface Constant {

    String JWT_SECRET="7786df7fc3a34e26a61c034d5ec8245d";

    interface Redis {
        //admin的登录缓存超时时间
        int OSP_TEACHER_TIMEOUT = 3600;
    }
}
