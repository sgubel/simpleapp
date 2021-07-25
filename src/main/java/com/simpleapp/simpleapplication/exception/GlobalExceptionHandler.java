package com.simpleapp.simpleapplication.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    ResponseEntity<?> exceptionHandling(Exception ex) {
        if (ex instanceof NotFoundException) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        if (ex instanceof DataIntegrityViolationException) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
