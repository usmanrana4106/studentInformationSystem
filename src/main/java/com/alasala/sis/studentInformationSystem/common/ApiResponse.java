package com.alasala.sis.studentInformationSystem.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse <T>{
    private boolean status;
    private String message;
    private T data;
}
