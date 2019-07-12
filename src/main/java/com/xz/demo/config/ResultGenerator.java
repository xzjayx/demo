package com.xz.demo.config;

import org.springframework.stereotype.Component;

@Component
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

  /*  public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCodeEnum.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result<T> getStatus(String message, T data) {
        return new Result()
                .setCode(ResultCodeEnum.SUCCESS)
                .setMessage(message)
                .setData(data);
    }

    public static <T> Result<T> getError(String message, T data) {
        return new Result()
                .setCode(ResultCodeEnum.FAIL)
                .setMessage(message)
                .setData(data);

    }

    public static <T> Result<T> genSuccessResult(T data) {
        return new Result<T>()
                .setCode(ResultCodeEnum.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static <T> Result<T> genSuccessResult(T data, String b) {
        return new Result<T>()
                .setCode(ResultCodeEnum.SUCCESS)
                .setMessage(b)
                .setData(data);
    }

    public static Result genSuccessMsg(String message) {
        return new Result().setCode(ResultCodeEnum.SUCCESS).setMessage(message);
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCodeEnum.FAIL)
                .setMessage(message);
    }

    public static Result genUnauthorizedResult() {
        return new Result()
                .setCode(ResultCodeEnum.UNAUTHORIZED)
                .setMessage("权限不足！");
    }

    public static Result genTokenErrorResult() {
        return new Result()
                .setCode(ResultCodeEnum.TOKEN_FAIL)
                .setMessage("认证失败");
    }

    public static Result genServerError() {
        return new Result()
                .setCode(ResultCodeEnum.INTERNAL_SERVER_ERROR)
                .setMessage("服务器未知错误");
    }

    public static Result genNotFoundError() {
        return new Result()
                .setCode(ResultCodeEnum.NOT_FOUND)
                .setMessage("找不到文件或者页面");
    }

    public static Result genException(Exception e) {
        return new Result().setMessage(e.toString());
    }*/

}
