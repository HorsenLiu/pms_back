package com.horsen.pms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.horsen.pms.model.Staff;
import com.horsen.pms.service.StaffService;
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
@Api(tags = "员工管理")
@CrossOrigin
@RestController
@RequestMapping("/staff")
public class StaffController {
    StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @ApiOperation("根据ID查询一个员工")
    @GetMapping("/{id}")
    public R queryStaffById(
            @ApiParam(name = "id", value = "员工ID")
            @PathVariable("id") Integer id) {
        Staff staff = staffService.queryStaffById(id);
        return R.success().setData("staff", staff);
    }

    @ApiOperation("查询所有员工")
    @GetMapping("/{page}/{limit}")
    public R queryStaffList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable("page") int page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable("limit") int limit) {
        PageHelper.startPage(page, limit);
        List<Staff> list = new PageInfo<>(staffService.queryStaffList()).getList();
        return R.success().setData("items", list);
    }

    @ApiOperation("根据条件查询员工")
    @PostMapping("/{page}/{limit}")
    public R queryStaff(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable("page") int page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable("limit") int limit,
            @ApiParam(name = "theStaff", value = "查询对象")
            @RequestBody(required = false) Staff theStaff) {
        PageHelper.startPage(page, limit);
        List<Staff> list = new PageInfo<>(staffService.queryStaff(theStaff)).getList();
        return R.success().setData("items", list);
    }
}
