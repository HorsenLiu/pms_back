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
    public List<ProjStaff> queryProjStaff(ProjStaff projStaff) {
        return projStaffMapper.queryProjStaff(projStaff);
    }

    @Override
    public int insertProjStaff(int projId, List<Integer> staffIds) {
        return projStaffMapper.insertProjStaff(projId, staffIds);
    }

    @Override
    public int deleteProjStaff(int projId) {
        return projStaffMapper.deleteProjStaff(projId);
    }
}
