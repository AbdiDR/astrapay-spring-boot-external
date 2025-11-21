package com.astrapay.controller.advice;

import com.astrapay.dto.response.BaseResponse;
import com.astrapay.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(
                new BaseResponse<>(
                        400,
                        ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(),
                        null
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<BaseResponse<String>> handleCustomException(CustomException ex) {

        HttpStatus status = ex.getHttpStatus();

        return new ResponseEntity<>(
                new BaseResponse<>(
                        status.value(),
                        ex.getMessage(),
                        null
                ),
                status
        );
    }
}
