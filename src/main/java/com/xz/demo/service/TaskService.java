package com.xz.demo.service;

import cn.hutool.core.util.ObjectUtil;
import com.xz.demo.config.general.SequenceId;
import com.xz.demo.config.task.DynamicTask;
import com.xz.demo.config.task.runnable.MyRunnable;
import com.xz.demo.dao.TaskMapper;
import com.xz.demo.model.pojo.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author xz
 */
@Service
public class TaskService {


    private final TaskMapper taskMapper;


    private final SequenceId sequenceId;

    private final DynamicTask dynamicTask;


    @Autowired
    public TaskService(TaskMapper taskMapper, SequenceId sequenceId, DynamicTask dynamicTask) {
        this.taskMapper = taskMapper;
        this.sequenceId = sequenceId;
        this.dynamicTask = dynamicTask;
    }


    public Task save(Task task){
        task.setId(sequenceId.nextId());
        taskMapper.insert(task);
        return task;
    }

    public Task findOneTaskByCondition(Task task){
        return taskMapper.findOneTaskByCondition(task);
    }

    public Boolean startCron(Task task){
        Task condition = taskMapper.findOneTaskByCondition(task);
        if(ObjectUtil.isEmpty(condition)){
            return false;
        }
        //查询到当前所属任务
        dynamicTask.startCron(new MyRunnable(),condition.getCron());
        return true;
    }


    public Boolean stopCron(Task task){
        Task condition = taskMapper.findOneTaskByCondition(task);
        if(ObjectUtil.isEmpty(condition)){
            return false;
        }
        dynamicTask.stopCron();
        return true;
    }

}
