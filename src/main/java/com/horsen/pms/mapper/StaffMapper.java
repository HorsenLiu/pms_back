package com.horsen.pms.mapper;

import com.horsen.pms.model.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Horsen
 */
@Repository
public interface StaffMapper {
    /**
     * 查询所有员工
     */
    List<Staff> queryStaffList();

    /**
     * 根据ID查询一个员工
     */
    Staff queryStaffById(int id);

    /**
     * 根据条件查询员工
     */
    List<Staff> queryStaff(Staff staff);

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
