package com.alasala.sis.studentInformationSystem.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {

    public static <T> ResponseEntity<ApiResponse<T>> success(String message, T data, HttpStatus status) {
        return new ResponseEntity<>(new ApiResponse<>(true, message, data), status);
    }

    public static <T> ResponseEntity<ApiResponse<T>> error(String message, HttpStatus status){
        return new ResponseEntity<>(new ApiResponse<>(false, message, null),status);
    }

    public static <T> ResponseEntity<ApiResponse<T>> attributeError(String message, HttpStatus status, T data){
        return new ResponseEntity<>(new ApiResponse<>(false,message,data),status);
    }
}
