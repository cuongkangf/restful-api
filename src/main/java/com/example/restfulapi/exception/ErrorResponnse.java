package com.example.restfulapi.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ErrorResponnse
 */

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ErrorResponnse {

    private HttpStatus httpStatus;
    private String message;
}