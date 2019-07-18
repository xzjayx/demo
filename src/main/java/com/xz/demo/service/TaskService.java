package com.xz.demo.service;

import com.xz.demo.config.general.SequenceId;
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

    @Autowired
    public TaskService(TaskMapper taskMapper, SequenceId sequenceId) {
        this.taskMapper = taskMapper;
        this.sequenceId = sequenceId;
    }


    public Task save(Task task){
        task.setId(sequenceId.nextId());
        taskMapper.insert(task);
        return task;
    }
}
