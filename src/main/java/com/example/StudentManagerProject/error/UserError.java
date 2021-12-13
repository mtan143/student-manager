package com.example.StudentManagerProject.error;

import com.example.StudentManagerProject.exception.BaseError;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum UserError implements BaseError {

    EXIST_USERNAME("EXIST_USERNAME", "Username is already taken!"),
    EXIST_EMAIL("EXIST_EMAIL", "Email is already taken!"),
    USER_INVALID("USER_INVALID", "User invalid! Try Again!"),
    ;


    private String code;
    private String message;

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
