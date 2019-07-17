package com.xz.demo.controller;

import com.xz.demo.config.ResponseJson;
import com.xz.demo.model.pojo.Order;
import com.xz.demo.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xiezhi
 */
@RestController
@RequestMapping("/order")
@Api(value = "/order",tags = "订单模块")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存订单", notes = "订单对象", response=Order.class)
    public ResponseJson save(
            @ApiParam(value = "订单对象", required = true)
            @RequestBody Order order){
        Order s = orderService.save(order);
        return new ResponseJson(s);
    }




   /* @GetMapping("/update/findDmStudentAspectById/{id}")
    @ApiOperation(value = "去更新页面,通过id查找学生人脸特征", notes = "返回响应对象", response=DmStudentAspect.class)
    public ResponseJson findDmStudentAspectById(
            @ApiParam(value = "去更新页面,需要用到的id", required = true)
            @PathVariable String id){
        DmStudentAspect dmStudentAspect=dmStudentAspectService.findDmStudentAspectById(id);
        return new ResponseJson(dmStudentAspect);
    }

    @PostMapping("/update/updateDmStudentAspect")
    @ApiOperation(value = "修改学生人脸特征对象非空字段", notes = "返回响应对象")
    public ResponseJson updateDmStudentAspect(
            @ApiParam(value = "被修改的学生人脸特征对象,对象属性不为空则修改", required = true)
            @RequestBody DmStudentAspect dmStudentAspect){
        dmStudentAspectService.updateDmStudentAspect(dmStudentAspect);
        return new ResponseJson();
    }

    @PostMapping("/update/updateDmStudentAspectForAll")
    @ApiOperation(value = "修改学生人脸特征对象所有字段", notes = "返回响应对象")
    public ResponseJson updateDmStudentAspectForAll(
            @ApiParam(value = "被修改的学生人脸特征对象", required = true)
            @RequestBody DmStudentAspect dmStudentAspect){
        dmStudentAspectService.updateDmStudentAspectForAll(dmStudentAspect);
        return new ResponseJson();
    }

    @GetMapping("/look/lookDmStudentAspectById/{id}")
    @ApiOperation(value = "去查看页面,通过id查找学生人脸特征", notes = "返回响应对象", response=DmStudentAspect.class)
    public ResponseJson lookDmStudentAspectById(
            @ApiParam(value = "去查看页面,需要用到的id", required = true)
            @PathVariable String id){
        DmStudentAspect dmStudentAspect=dmStudentAspectService.findDmStudentAspectById(id);
        return new ResponseJson(dmStudentAspect);
    }

    @PostMapping("/findDmStudentAspectsByCondition")
    @ApiOperation(value = "根据条件查找学生人脸特征", notes = "返回响应对象", response=DmStudentAspect.class)
    public ResponseJson findDmStudentAspectsByCondition(
            @ApiParam(value = "属性不为空则作为条件查询")
            @Validated
            @RequestBody DmStudentAspect dmStudentAspect){
        dmStudentAspect.setSchoolId(mySchoolId());
        List<DmStudentAspect> data=dmStudentAspectService.findDmStudentAspectListByCondition(dmStudentAspect);
        long count=dmStudentAspectService.findDmStudentAspectCountByCondition(dmStudentAspect);
        return new ResponseJson(data,count);
    }
    @PostMapping("/findOneDmStudentAspectByCondition")
    @ApiOperation(value = "根据条件查找单个学生人脸特征,结果必须为单条数据", notes = "没有时返回空", response=DmStudentAspect.class)
    public ResponseJson findOneDmStudentAspectByCondition(
            @ApiParam(value = "属性不为空则作为条件查询")
            @RequestBody DmStudentAspect dmStudentAspect){
        DmStudentAspect one=dmStudentAspectService.findOneDmStudentAspectByCondition(dmStudentAspect);
        return new ResponseJson(one);
    }
    @GetMapping("/deleteDmStudentAspect/{id}")
    @ApiOperation(value = "根据id删除", notes = "返回响应对象")
    public ResponseJson deleteDmStudentAspect(
            @ApiParam(value = "被删除记录的id", required = true)
            @PathVariable String id){
        dmStudentAspectService.deleteDmStudentAspect(id);
        return new ResponseJson();
    }


    @PostMapping("/findDmStudentAspectListByCondition")
    @ApiOperation(value = "根据条件查找学生人脸特征列表", notes = "返回响应对象,不包含总条数", response=DmStudentAspect.class)
    public ResponseJson findDmStudentAspectListByCondition(
            @ApiParam(value = "属性不为空则作为条件查询")
            @Validated
            @RequestBody DmStudentAspect dmStudentAspect){
        dmStudentAspect.setSchoolId(mySchoolId());
        List<DmStudentAspect> data=dmStudentAspectService.findDmStudentAspectListByCondition(dmStudentAspect);
        return new ResponseJson(data);
    }*/
}
