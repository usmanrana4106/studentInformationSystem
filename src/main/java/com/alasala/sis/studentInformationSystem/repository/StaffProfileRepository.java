package com.alasala.sis.studentInformationSystem.repository;

import com.alasala.sis.studentInformationSystem.entity.StaffProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffProfileRepository extends JpaRepository<StaffProfile, Integer> {
}
