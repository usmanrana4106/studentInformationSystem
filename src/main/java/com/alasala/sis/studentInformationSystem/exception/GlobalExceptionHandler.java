package com.alasala.sis.studentInformationSystem.exception;

import com.alasala.sis.studentInformationSystem.common.ApiResponse;
import com.alasala.sis.studentInformationSystem.common.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlreadyExistRecordException.class)
    public ResponseEntity<ApiResponse<Object>> handleRecordAlreadyExist(AlreadyExistRecordException ex){
        return ResponseBuilder.error(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGenericException(Exception ex){
        return ResponseBuilder.error(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleArgumentRequiredException(MethodArgumentNotValidException ex){
        Map<String,String> errors= new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseBuilder.attributeError("Validation Errors",HttpStatus.BAD_REQUEST,errors);
    }
}
