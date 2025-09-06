package com.alasala.sis.studentInformationSystem.exception;

public class AlreadyExistRecordException extends RuntimeException {
    public AlreadyExistRecordException(String message){
        super(message);
    }
}
