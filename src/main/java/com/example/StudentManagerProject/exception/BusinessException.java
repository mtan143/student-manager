package com.example.StudentManagerProject.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessException extends RuntimeException{

    private String code;
    private String message;

    public BusinessException(BaseError error) {
        this.code = error.getCode();
        this.message = error.getMessage();
    }
}