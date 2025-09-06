package com.alasala.sis.studentInformationSystem.service;

import com.alasala.sis.studentInformationSystem.dto.AddStudentDto;
import com.alasala.sis.studentInformationSystem.dto.GetStudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    GetStudentDto getStudentByID(String studentId);
    List<GetStudentDto> getStudentsList();
    GetStudentDto addStudent(AddStudentDto addStudentDto);
    boolean deleteStudent(String studentId);

    GetStudentDto updateStudent(String studentId, AddStudentDto addStudentDto);

    GetStudentDto patchStudent(String studentId, AddStudentDto addStudentDto);
}
