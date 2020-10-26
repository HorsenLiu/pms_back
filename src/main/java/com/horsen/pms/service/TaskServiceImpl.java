package com.horsen.pms.service;

import com.horsen.pms.mapper.TaskMapper;
import com.horsen.pms.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Horsen
 */
@Service
public class TaskServiceImpl implements TaskService {

    TaskMapper taskMapper;

    @Autowired
    public TaskServiceImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public List<Task> queryTaskList() {
        return taskMapper.queryTaskList();
    }

    @Override
    public Task queryTaskById(int id) {
        return taskMapper.queryTaskById(id);
    }

    @Override
    public List<Task> queryTask(Task task) {
        return taskMapper.queryTask(task);
    }

    @Override
    public int insertTask(Task task) {
        return taskMapper.insertTask(task);
    }

    @Override
    public int updateTask(Task task) {
        return taskMapper.updateTask(task);
    }

    @Override
    public int deleteTask(int id) {
        return taskMapper.deleteTask(id);
    }
}
