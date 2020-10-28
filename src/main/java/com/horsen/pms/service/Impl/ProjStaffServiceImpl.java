package com.horsen.pms.service.Impl;

import com.horsen.pms.mapper.ProjStaffMapper;
import com.horsen.pms.model.ProjStaff;
import com.horsen.pms.service.ProjStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Horsen
 */
@Service
public class ProjStaffServiceImpl implements ProjStaffService {

    ProjStaffMapper projStaffMapper;

    @Autowired
    public ProjStaffServiceImpl(ProjStaffMapper projStaffMapper) {
        this.projStaffMapper = projStaffMapper;
    }

    @Override
    public List<ProjStaff> queryProjStaffList() {
        return projStaffMapper.queryProjStaffList();
    }

    @Override
    public ProjStaff queryProjStaffById(int id) {
        return projStaffMapper.queryProjStaffById(id);
    }

    @Override
    public List<ProjStaff> queryProjStaff(ProjStaff projStaff) {
        return projStaffMapper.queryProjStaff(projStaff);
    }

    @Override
    public int insertProjStaff(ProjStaff projStaff) {
        return projStaffMapper.insertProjStaff(projStaff);
    }

    @Override
    public int updateProjStaff(ProjStaff projStaff) {
        return projStaffMapper.updateProjStaff(projStaff);
    }

    @Override
    public int deleteProjStaff(int id) {
        return projStaffMapper.deleteProjStaff(id);
    }
}
