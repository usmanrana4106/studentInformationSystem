package com.alasala.sis.studentInformationSystem.repository;

import com.alasala.sis.studentInformationSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student getByStudentId(String studentId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Student s WHERE s.studentId = :studentId")
    int deleteByStudentId(@Param("studentId") String studentId);
}
