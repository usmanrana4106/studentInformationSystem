package com.alasala.sis.studentInformationSystem.service;

import com.alasala.sis.studentInformationSystem.entity.StaffProfile;

import java.util.List;

public interface StaffProfileService {
    public List<StaffProfile> getAllStaffMembers();
    public StaffProfile getStaffbyId(int id);
}
