package com.horsen.pms.mapper;

import com.horsen.pms.model.ProjStaff;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjStaffMapper {
    /**
     * 根据条件查询项目_员工
     */
    List<ProjStaff> queryProjStaff(ProjStaff projStaff);

    /**
     * 插入一组项目_员工
     */
    int insertProjStaff(@Param("projId") int projId, @Param("staffIds") List<Integer> staffIds);

    /**
     * 根据项目ID删除所有对应的项目_员工
     */
    int deleteProjStaff(@Param("projId") int projId);
}
