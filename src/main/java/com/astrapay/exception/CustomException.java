package com.astrapay.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException{
    private final HttpStatus httpStatus;
    private final int errorCode;

    public CustomException(String message, HttpStatus httpStatus, int errorCode) {
        super(message);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
    }
}
