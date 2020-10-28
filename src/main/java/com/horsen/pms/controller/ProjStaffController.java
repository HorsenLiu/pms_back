package com.horsen.pms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.horsen.pms.model.ProjStaff;
import com.horsen.pms.service.ProjStaffService;
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
@Api(tags = "项目_员工管理")
@CrossOrigin
@RestController
@RequestMapping("/projStaff")
public class ProjStaffController {
    ProjStaffService projStaffService;

    @Autowired
    public ProjStaffController(ProjStaffService projStaffService) {
        this.projStaffService = projStaffService;
    }

    @ApiOperation("根据ID查询一个项目_员工")
    @GetMapping("/{id}")
    public R queryProjStaffById(
            @ApiParam(name = "id", value = "项目_员工ID", required = true)
            @PathVariable("id") Integer id) {
        ProjStaff projStaff = projStaffService.queryProjStaffById(id);
        return R.success().setData("projStaff", projStaff);
    }

    @ApiOperation("查询所有项目_员工")
    @GetMapping("/{page}/{limit}")
    public R queryProjStaffList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable("page") int page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable("limit") int limit) {
        PageHelper.startPage(page, limit);
        List<ProjStaff> list = new PageInfo<>(projStaffService.queryProjStaffList()).getList();
        return R.success().setData("items", list);
    }

    @ApiOperation("根据条件查询项目_员工")
    @PostMapping("/{page}/{limit}")
    public R queryProjStaff(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable("page") int page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable("limit") int limit,
            @ApiParam(name = "theProjStaff", value = "查询对象")
            @RequestBody(required = false) ProjStaff theProjStaff) {
        PageHelper.startPage(page, limit);
        List<ProjStaff> list = new PageInfo<>(projStaffService.queryProjStaff(theProjStaff)).getList();
        return R.success().setData("items", list);
    }

    @ApiOperation("插入一个项目_员工")
    @PostMapping("/")
    public R insertProjStaff(
            @ApiParam(name = "projStaff", value = "项目_员工对象", required = true)
            @RequestBody ProjStaff projStaff) {
        int i = projStaffService.insertProjStaff(projStaff);
        if (i != 0) {
            return R.success();
        }
        return R.error().setMessage("插入失败");
    }

    @ApiOperation("根据ID删除一个项目_员工")
    @DeleteMapping("/{id}")
    public R deleteProjStaff(
            @ApiParam(name = "id", value = "主键ID", required = true)
            @PathVariable("id") int id) {
        int i = projStaffService.deleteProjStaff(id);
        if (i != 0) {
            return R.success();
        }
        return R.error().setMessage("删除失败");
    }

    @ApiOperation("修改一个项目_员工")
    @PutMapping("/{id}")
    public R updateProjStaff(
            @ApiParam(name = "id", value = "主键ID", required = true)
            @PathVariable("id") int id,
            @ApiParam(name = "projStaff", value = "项目_员工对象", required = true)
            @RequestBody ProjStaff projStaff) {
        projStaff.setId(id);
        int i = projStaffService.updateProjStaff(projStaff);
        if (i != 0) {
            return R.success();
        }
        return R.error().setMessage("修改失败");
    }
}
