package com.horsen.pms.mapper;

import com.horsen.pms.model.ProjStaff;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjStaffMapper {
    /**
     * 根据ID查询一个项目_员工
     */
    ProjStaff queryProjStaffById(@Param("id") int id);

    /**
     * 根据条件查询项目_员工
     */
    List<ProjStaff> queryProjStaff(ProjStaff projStaff);

    /**
     * 插入一个项目_员工
     */
    int insertProjStaff(ProjStaff projStaff);

    /**
     * 修改一个项目_员工
     */
    int updateProjStaff(ProjStaff projStaff);

    /**
     * 根据ID删除一个项目_员工
     */
    int deleteProjStaff(@Param("id") int id);
}
