package com.horsen.pms.service;

import com.horsen.pms.model.Task;

import java.util.List;

/**
 * @author Horsen
 */
public interface TaskService {
    /**
     * 查询所有任务
     */
    List<Task> queryTaskList();

    /**
     * 根据ID查询一个任务
     */
    Task queryTaskById(int id);

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
    int deleteTask(int id);
}
