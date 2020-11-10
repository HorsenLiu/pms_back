package com.horsen.pms.mapper;

import com.horsen.pms.model.Task;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskMapper {
    /**
     * 根据ID查询一个任务
     */
    Task queryTaskById(@Param("id") int id);

    /**
     * 根据条件查询任务
     */
    List<Task> queryTask(Task task);

    /**
     * 插入一个任务
     */
    int insertTask(Task task);

    /**
     * 修改一个任务
     */
    int updateTask(Task task);

    /**
     * 根据ID删除一个任务
     */
    int deleteTask(@Param("id") int id);
}
