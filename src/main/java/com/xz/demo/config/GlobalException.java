package com.xz.demo.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public ResponseJson jsonErrorHandler(HttpServletRequest req, Exception e){
        return new ResponseJson(false,e.getMessage());
    }

}
