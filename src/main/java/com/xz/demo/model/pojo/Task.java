package com.xz.demo.model.pojo;

import lombok.Data;

/**
 * 定时任务表
 * @author xz
 */
@Data
public class Task {

    private String id;

    private String taskKey;

    private String taskDescription;

    private String taskGroup;

    private String taskName;

    private String cron;

    private String createDate;

    private String modifyDate;

    private String status;

}
