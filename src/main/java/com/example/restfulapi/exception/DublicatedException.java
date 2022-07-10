package com.example.restfulapi.exception;

public class DublicatedException extends RuntimeException {
    public DublicatedException(String message) {
        super(message);
    }
}
