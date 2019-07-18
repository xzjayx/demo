package com.xz.demo.config.general;

import com.xz.demo.config.ResponseJson;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xz
 */
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public ResponseJson jsonErrorHandler(HttpServletRequest req, Exception e){
        return new ResponseJson(false,e.getMessage());
    }

}
