package com.example.restfulapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponnse handlerNotFoundException(NotFoundException ex, WebRequest req) {

        return new ErrorResponnse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(DublicatedException.class)
    public ErrorResponnse handlerDublicatedException(DublicatedException ex, WebRequest req) {

        return new ErrorResponnse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
}
