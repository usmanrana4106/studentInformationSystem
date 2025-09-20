package com.alasala.sis.studentInformationSystem.service.impl;

import com.alasala.sis.studentInformationSystem.entity.StaffProfile;
import com.alasala.sis.studentInformationSystem.repository.StaffProfileRepository;
import com.alasala.sis.studentInformationSystem.service.StaffProfileService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffProfileServiceImpl implements StaffProfileService {

    private final StaffProfileRepository staffProfileRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StaffProfile> getAllStaffMembers() {
        List<StaffProfile> list = staffProfileRepository.findAll();
        return list;
    }

    @Override
    public StaffProfile getStaffbyId(int id) {
        StaffProfile staffProfile = staffProfileRepository.getById(id);
        if (staffProfile == null) {
            throw new RuntimeException("Staff not found with id: " + id);
        }
        return staffProfile;
    }
}
