package com.alasala.sis.studentInformationSystem.controller;

import com.alasala.sis.studentInformationSystem.common.ApiResponse;
import com.alasala.sis.studentInformationSystem.common.ResponseBuilder;
import com.alasala.sis.studentInformationSystem.entity.StaffProfile;
import com.alasala.sis.studentInformationSystem.service.StaffProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/staff")
public class StaffController {

    private final StaffProfileService staffProfileService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<StaffProfile>>> getStaffList(){
        List<StaffProfile> staffMembers = staffProfileService.getAllStaffMembers();
        return ResponseBuilder.success("staff Profile List ",staffMembers, HttpStatus.OK);
    }

    @GetMapping("/getstaffbyid/{id}")
    public ResponseEntity<ApiResponse<StaffProfile>> getStaffById(@RequestParam("id") int id){
        StaffProfile staffMembers = staffProfileService.getStaffbyId(id);
        return ResponseBuilder.success("staff Profile List ",staffMembers, HttpStatus.OK);
    }
}
