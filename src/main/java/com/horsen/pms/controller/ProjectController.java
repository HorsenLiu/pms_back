package com.horsen.pms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.horsen.pms.model.Project;
import com.horsen.pms.service.ProjectService;
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
@Api(tags = "项目管理")
@CrossOrigin
@RestController
@RequestMapping("/project")
public class ProjectController {
    ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @ApiOperation("根据ID查询一个项目")
    @GetMapping("/{id}")
    public R queryProjectById(
            @ApiParam(name = "id", value = "项目ID", required = true)
            @PathVariable("id") Integer id) {
        Project project = projectService.queryProjectById(id);
        return R.success().setData("project", project);
    }

    @ApiOperation("查询所有项目")
    @GetMapping("/{page}/{limit}")
    public R queryProjectList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable("page") int page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable("limit") int limit) {
        PageHelper.startPage(page, limit);
        List<Project> list = new PageInfo<>(projectService.queryProjectList()).getList();
        return R.success().setData("items", list);
    }

    @ApiOperation("根据条件查询项目")
    @PostMapping("/{page}/{limit}")
    public R queryProject(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable("page") int page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable("limit") int limit,
            @ApiParam(name = "theProject", value = "查询对象")
            @RequestBody(required = false) Project theProject) {
        PageHelper.startPage(page, limit);
        List<Project> list = new PageInfo<>(projectService.queryProject(theProject)).getList();
        return R.success().setData("items", list);
    }

    @ApiOperation("插入一个项目")
    @PostMapping("/")
    public R insertProject(
            @ApiParam(name = "project", value = "项目对象", required = true)
            @RequestBody Project project) {
        int i = projectService.insertProject(project);
        if (i != 0) {
            return R.success();
        }
        return R.error().setMessage("插入失败");
    }

    @ApiOperation("根据ID删除一个项目")
    @DeleteMapping("/{id}")
    public R deleteProject(
            @ApiParam(name = "id", value = "项目ID", required = true)
            @PathVariable("id") int id) {
        int i = projectService.deleteProject(id);
        if (i != 0) {
            return R.success();
        }
        return R.error().setMessage("删除失败");
    }

    @ApiOperation("修改一个项目")
    @PutMapping("/{id}")
    public R updateProject(
            @ApiParam(name = "id", value = "项目ID", required = true)
            @PathVariable("id") int id,
            @ApiParam(name = "project", value = "项目对象", required = true)
            @RequestBody Project project) {
        project.setId(id);
        int i = projectService.updateProject(project);
        if (i != 0) {
            return R.success();
        }
        return R.error().setMessage("修改失败");
    }
}
