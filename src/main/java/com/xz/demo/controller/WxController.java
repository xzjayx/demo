package com.xz.demo.controller;

import com.xz.demo.config.ResponseJson;
import com.xz.demo.config.wx.WXPay;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xz
 */
@RestController
@RequestMapping("/wx")
@Api(value = "/wx",tags = "微信接口模块")
public class WxController {


    @ApiOperation(value = "微信统一下单接口",notes = "返回相关信息")
    @PostMapping("/wxpay")
    public ResponseJson wxpay(){
        // 1 基本上需要用微信统一下单 构建wxpay对象   public WXPay(final WXPayConfig config,
        // final String notifyUrl, final boolean autoReport, final boolean useSandbox)

        // 2  要想构建wxpay对象 需要注入 WXPayConfig 对象 则需要一个来实现基础的 WXPayConfig 派生类书写自己的配置

        return new ResponseJson(true,"响应成功");
    }



}
