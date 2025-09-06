package com.alasala.sis.studentInformationSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetStudentDto {
    private int id;
    private String studentId;
    private int genderId;
    private String name;
    private String mobile;
    private String cnic;
    private int age;
    private LocalDate dobYear;
}
