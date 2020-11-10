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
            @ApiParam(name = "id", value = "员工ID", required = true)
            @PathVariable("id") Integer id) {
        Staff staff = staffService.queryStaffById(id);
        return R.success().setData("staff", staff);
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
        PageInfo<Staff> pageInfo = new PageInfo<>(staffService.queryStaff(theStaff));
        List<Staff> list = pageInfo.getList();
        long total = pageInfo.getTotal();
        return R.success().setData("items", list).setData("total", total);
    }

    @ApiOperation("插入一个员工")
    @PostMapping("/")
    public R insertStaff(
            @ApiParam(name = "staff", value = "员工对象", required = true)
            @RequestBody Staff staff) {
        int i = staffService.insertStaff(staff);
        if (i != 0) {
            return R.success();
        }
        return R.error().setMessage("插入失败");
    }

    @ApiOperation("根据ID删除一个员工")
    @DeleteMapping("/{id}")
    public R deleteStaff(
            @ApiParam(name = "id", value = "员工ID", required = true)
            @PathVariable("id") int id) {
        int i = staffService.deleteStaff(id);
        if (i != 0) {
            return R.success();
        }
        return R.error().setMessage("删除失败");
    }

    @ApiOperation("修改一个员工")
    @PutMapping("/{id}")
    public R updateStaff(
            @ApiParam(name = "id", value = "员工ID", required = true)
            @PathVariable("id") int id,
            @ApiParam(name = "staff", value = "员工对象", required = true)
            @RequestBody Staff staff) {
        staff.setId(id);
        int i = staffService.updateStaff(staff);
        if (i != 0) {
            return R.success();
        }
        return R.error().setMessage("修改失败");
    }
}
