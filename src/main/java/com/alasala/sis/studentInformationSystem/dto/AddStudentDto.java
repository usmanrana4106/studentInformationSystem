package com.alasala.sis.studentInformationSystem.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddStudentDto {
    private String studentId;
    @NotNull(message = "Gender is required for male its 1 for female its 2")
    @Min(value = 1, message = "Gender must be either 1 for male or female its 2")
    @Max(value = 2, message = "Gender must be either 1 for male or female its 2")
    private int genderId;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "mobile is required")
    private String mobile;
    private String cnic;
    private int age;
    private LocalDate dobYear;
}
