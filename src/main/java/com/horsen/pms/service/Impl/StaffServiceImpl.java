package com.horsen.pms.service.Impl;

import com.horsen.pms.mapper.StaffMapper;
import com.horsen.pms.model.Staff;
import com.horsen.pms.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Horsen
 */
@Service
public class StaffServiceImpl implements StaffService {

    StaffMapper staffMapper;

    @Autowired
    public StaffServiceImpl(StaffMapper staffMapper) {
        this.staffMapper = staffMapper;
    }

    @Override
    public List<Map<Integer, String>> queryStaffNames(Staff staff) {
        return staffMapper.queryStaffNames(staff);
    }

    @Override
    public List<Integer> queryStaffIdsByProjId(int projId) {
        return staffMapper.queryStaffIdsByProjId(projId);
    }

    @Override
    public Staff queryStaffById(int id) {
        return staffMapper.queryStaffById(id);
    }

    @Override
    public List<Staff> queryStaff(Staff staff) {
        return staffMapper.queryStaff(staff);
    }

    @Override
    public int insertStaff(Staff staff) {
        return staffMapper.insertStaff(staff);
    }

    @Override
    public int updateStaff(Staff staff) {
        return staffMapper.updateStaff(staff);
    }

    @Override
    public int deleteStaff(int id) {
        return staffMapper.deleteStaff(id);
    }
}
