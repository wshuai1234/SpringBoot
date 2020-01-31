package com.example.demo.exception;

public class NotFoundException extends RuntimeException {


    /**
     * Don't let anyone else instantiate this class
     */
    public NotFoundException(String message) {
        super(message);
    }
}
