package com.horsen.pms.service;

import com.horsen.pms.model.Project;

import java.util.List;

/**
 * @author Horsen
 */
public interface ProjectService {
    /**
     * 根据ID查询一个项目
     */
    Project queryProjectById(int id);

    /**
     * 根据条件查询项目
     */
    List<Project> queryProject(Project project);

    /**
     * 根据员工ID查询项目
     */
    List<Project> queryProjectByStaffId(int staffId);

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
    int deleteProject(int id);
}
