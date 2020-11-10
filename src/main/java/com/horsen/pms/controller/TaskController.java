package com.horsen.pms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.horsen.pms.model.Task;
import com.horsen.pms.service.TaskService;
import com.horsen.pms.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Horsen
 */
@Api(tags = "任务管理")
@CrossOrigin
@RestController
@RequestMapping("/task")
public class TaskController {
    TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @ApiOperation("根据ID查询一个任务")
    @GetMapping("/{id}")
    public R queryTaskById(
            @ApiParam(name = "id", value = "任务ID", required = true)
            @PathVariable("id") Integer id) {
        Task task = taskService.queryTaskById(id);
        return R.success().setData("task", task);
    }

    @ApiOperation("根据条件查询任务")
    @PostMapping("/{page}/{limit}")
    public R queryTask(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable("page") int page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable("limit") int limit,
            @ApiParam(name = "theTask", value = "查询对象")
            @RequestBody(required = false) Task theTask) {
        PageHelper.startPage(page, limit);
        List<Task> list = new PageInfo<>(taskService.queryTask(theTask)).getList();
        return R.success().setData("items", list);
    }

    @ApiOperation("插入一个任务")
    @PostMapping("/")
    public R insertTask(
            @ApiParam(name = "task", value = "任务对象", required = true)
            @RequestBody Task task) {
        int i = taskService.insertTask(task);
        if (i != 0) {
            return R.success();
        }
        return R.error().setMessage("插入失败");
    }

    @ApiOperation("根据ID删除一个任务")
    @DeleteMapping("/{id}")
    public R deleteTask(
            @ApiParam(name = "id", value = "任务ID", required = true)
            @PathVariable("id") int id) {
        int i = taskService.deleteTask(id);
        if (i != 0) {
            return R.success();
        }
        return R.error().setMessage("删除失败");
    }

    @ApiOperation("修改一个任务")
    @PutMapping("/{id}")
    public R updateTask(
            @ApiParam(name = "id", value = "任务ID", required = true)
            @PathVariable("id") int id,
            @ApiParam(name = "task", value = "任务对象", required = true)
            @RequestBody Task task) {
        task.setId(id);
        int i = taskService.updateTask(task);
        if (i != 0) {
            return R.success();
        }
        return R.error().setMessage("修改失败");
    }
}
