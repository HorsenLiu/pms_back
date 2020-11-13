package com.horsen.pms.mapper;

import com.horsen.pms.model.Project;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMapper {
    /**
     * 根据ID查询一个项目
     */
    Project queryProjectById(@Param("id") int id);

    /**
     * 根据条件查询项目
     */
    List<Project> queryProject(Project project);

    /**
     * 根据员工ID查询项目
     */
    List<Project> queryProjectByStaffId(@Param("staffId") int staffId);

    /**
     * 插入一个项目
     */
    int insertProject(Project project);

    /**
     * 修改一个项目
     */
    int updateProject(Project project);

    /**
     * 根据ID删除一个项目
     */
    int deleteProject(@Param("id") int id);
}
