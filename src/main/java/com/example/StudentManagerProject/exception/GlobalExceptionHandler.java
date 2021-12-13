package com.example.StudentManagerProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    /**Handle all business exception*/
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus
    public ResponseEntity<?> handleBusinessError(BusinessException e) {
        e.setStackTrace(new StackTraceElement[]{});
        return ResponseEntity.of(Optional.of(e));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handleUnexpectedError(Exception e) {
        BusinessException businessException = new BusinessException(Status.FAILED.name(), e.getMessage());
        businessException.setStackTrace(new StackTraceElement[]{});
        return ResponseEntity.of(Optional.of(businessException));
    }

}
