package com.coding.spring_rest_crud.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable err) {
        super(message, err);
    }

}
