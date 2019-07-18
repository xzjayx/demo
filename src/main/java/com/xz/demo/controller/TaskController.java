package com.xz.demo.controller;

import com.xz.demo.config.ResponseJson;
import com.xz.demo.model.pojo.Order;
import com.xz.demo.model.pojo.Task;
import com.xz.demo.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            @ApiParam(value = "订单对象", required = true)
            @RequestBody Task task){
        Task s = taskService.save(task);
        return new ResponseJson(s);
    }
}
