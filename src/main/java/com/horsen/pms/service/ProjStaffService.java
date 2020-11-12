package com.horsen.pms.service;

import com.horsen.pms.model.ProjStaff;

import java.util.List;

/**
 * @author Horsen
 */
public interface ProjStaffService {
    /**
     * 根据条件查询项目_员工
     */
    List<ProjStaff> queryProjStaff(ProjStaff projStaff);

    /**
     * 插入一个项目_员工
     */
    int insertProjStaff(int projId, List<Integer> staffIds);

    /**
     * 根据项目ID删除所有对应的项目_员工
     */
    int deleteProjStaff(int projId);
}
