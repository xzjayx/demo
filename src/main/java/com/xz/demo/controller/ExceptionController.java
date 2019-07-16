package com.xz.demo.controller;

import com.xz.demo.config.ResponseJson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiezhi
 */
@RestController
@RequestMapping("/exception")
public class ExceptionController {


    @PostMapping("/401")
    public ResponseJson exception401(){
        return new ResponseJson(false,"token错误异常");
    }

    @PostMapping("/403")
    public ResponseJson exception403(){
        return new ResponseJson(false,"token失效");
    }
}
