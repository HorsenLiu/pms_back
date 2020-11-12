package com.horsen.pms.controller;

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

    @ApiOperation("根据条件查询项目_员工")
    @GetMapping("/")
    public R queryProjStaff(
            @ApiParam(name = "theProjStaff", value = "查询对象")
            @RequestBody(required = false) ProjStaff theProjStaff) {
        List<ProjStaff> list = projStaffService.queryProjStaff(theProjStaff);
        return R.success().setData("items", list);
    }

    @ApiOperation("插入一个项目_员工")
    @PostMapping("/{projId}")
    public R insertProjStaff(
            @ApiParam(name = "projId", value = "项目ID", required = true)
            @PathVariable("projId") int projId,
            @ApiParam(name = "staffId", value = "员工ID", required = true)
            @RequestBody(required = true) List<Integer> staffIds) {
        int i = projStaffService.insertProjStaff(projId, staffIds);
        if (i != 0) {
            return R.success();
        }
        return R.error().setMessage("插入失败");
    }

    @ApiOperation("根据项目ID删除所有对应的项目_员工")
    @DeleteMapping("/{projId}")
    public R deleteProjStaff(
            @ApiParam(name = "projId", value = "项目ID", required = true)
            @PathVariable("projId") int projId) {
        int i = projStaffService.deleteProjStaff(projId);
        if (i != 0) {
            return R.success();
        }
        return R.error().setMessage("删除失败");
    }
}
