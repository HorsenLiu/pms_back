package com.horsen.pms.service;

import com.horsen.pms.model.Staff;

import java.util.List;
import java.util.Map;

/**
 * @author Horsen
 */
public interface StaffService {
    /**
     * 根据ID查询一个员工
     */
    Staff queryStaffById(int id);

    /**
     * 根据条件查询员工
     */
    List<Staff> queryStaff(Staff staff);

    /**
     * 根据条件查询员工姓名
     */
    List<Map<Integer, String>> queryStaffNames(Staff staff);

    /**
     * 根据项目ID查询员工姓名
     */
    List<Integer> queryStaffIdsByProjId(int projId);

    /**
     * 插入一个员工
     */
    int insertStaff(Staff staff);

    /**
     * 修改一个员工
     */
    int updateStaff(Staff staff);

    /**
     * 根据ID删除一个员工
     */
    int deleteStaff(int id);
}
