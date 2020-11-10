package com.horsen.pms.mapper;

import com.horsen.pms.model.Staff;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Horsen
 */
@Repository
public interface StaffMapper {
    /**
     * 根据ID查询一个员工
     */
    Staff queryStaffById(@Param("id") int id);

    /**
     * 根据条件查询员工
     */
    List<Staff> queryStaff(Staff staff);

    /**
     * 查询员工姓名
     */
    List<String> queryStaffNames(Staff staff);

    /**
     * 根据项目ID查询员工姓名
     */
    List<String> queryStaffNamesByProjId(@Param("projId") int projId);

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
    int deleteStaff(@Param("id") int id);
}
