package com.xz.demo.controller;

import com.xz.demo.config.ResponseJson;
import com.xz.demo.model.pojo.Order;
import com.xz.demo.model.pojo.Task;
import com.xz.demo.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xz
 */
@RestController
@RequestMapping("/task")
@Api(value = "/task", tags = "定时任务模块")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存任务", notes = "任务对象", response= Task.class)
    public ResponseJson save(
            @ApiParam(value = "任务对象", required = true)
            @RequestBody Task task){
        Task s = taskService.save(task);
        return new ResponseJson(s);
    }


    @PostMapping("/startCron")
    @ApiOperation(value = "启动定时任务", notes = "任务对象", response= Task.class)
    public ResponseJson startCron(
            @ApiParam(value = "任务对象", required = true)
            @RequestBody Task task){
        Boolean cron = taskService.startCron(task);
        if(cron){
            return  new ResponseJson(true,"响应成功");
        }
        return new ResponseJson(false,"定时器执行错误");
    }

    @PostMapping("/stopCron")
    @ApiOperation(value = "停止定时任务", notes = "任务对象", response= Task.class)
    public ResponseJson stopCron(
            @ApiParam(value = "任务对象", required = true)
            @RequestBody Task task){
        Boolean cron = taskService.stopCron(task);
        if(cron){
            return  new ResponseJson(true,"停止任务成功");
        }
        return new ResponseJson(false,"定时器执行错误");
    }


}
