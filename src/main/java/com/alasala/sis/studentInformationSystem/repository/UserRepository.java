package com.alasala.sis.studentInformationSystem.repository;

import com.alasala.sis.studentInformationSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}
