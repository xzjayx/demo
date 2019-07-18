package com.xz.demo.dao;

import com.xz.demo.model.pojo.Task;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xz
 */
@Mapper
public interface TaskMapper {
    int deleteByPrimaryKey(String id);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);
}
