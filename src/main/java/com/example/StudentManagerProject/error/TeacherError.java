package com.example.StudentManagerProject.error;

import com.example.StudentManagerProject.exception.BaseError;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum TeacherError implements BaseError {

    TEACHER("TEACHER_INVALID", "TEACHER IS NULL"),
    TEACHER_ID("TEACHER_ID", "TEACHER ID IS NULL"),
    CLASS_ID("CLASS_ID", "CLASS ID IS NULL"),
    SUBJECT_ID("SUBJECT_ID", "SUBJECT ID IS NULL"),
    CARD_ID_INVALID("CARD_ID_INVALID", "CARD ID IS INVALID"),
    SALARY_INVALID("SALARY_INVALID", "SALARY IS INVALID"),
    FIRST_NAME_INVALID("FIRST_NAME_INVALID", "FIRST NAME IS INVALID"),
    LAST_NAME_INVALID("LAST_NAME_INVALID", "LAST NAME IS INVALID"),
    USERNAME_INVALID("USERNAME_INVALID", "USERNAME IS INVALID"),
    EMAIL_INVALID("EMAIL_INVALID", "EMAIL IS INVALID"),
    PASSWORD_INVALID("PASSWORD_INVALID", "PASSWORD IS INVALID"),
    LIST_EMPTY("LIST_EMPTY", "LIST OF TEACHERS IS EMPTY");


    private String code;
    private String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
