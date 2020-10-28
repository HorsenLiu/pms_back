package com.horsen.pms.service.Impl;

import com.horsen.pms.mapper.ProjectMapper;
import com.horsen.pms.model.Project;
import com.horsen.pms.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Horsen
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    ProjectMapper projectMapper;

    @Autowired
    public ProjectServiceImpl(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    @Override
    public List<Project> queryProjectList() {
        return projectMapper.queryProjectList();
    }

    @Override
    public Project queryProjectById(int id) {
        return projectMapper.queryProjectById(id);
    }

    @Override
    public List<Project> queryProject(Project project) {
        return projectMapper.queryProject(project);
    }

    @Override
    public int insertProject(Project project) {
        return projectMapper.insertProject(project);
    }

    @Override
    public int updateProject(Project project) {
        return projectMapper.updateProject(project);
    }

    @Override
    public int deleteProject(int id) {
        return projectMapper.deleteProject(id);
    }
}
