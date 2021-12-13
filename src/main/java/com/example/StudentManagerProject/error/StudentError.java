package com.example.StudentManagerProject.error;

import com.example.StudentManagerProject.exception.BaseError;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum StudentError implements BaseError {

    STUDENT("STUDENT_INVALID", "STUDENT IS NULL"),
    STUDENT_ID("STUDENT_ID", "STUDENT ID IS NULL"),
    CLASS_ID_INVALID("CLASS_ID_INVALID", "CLASS ID IS INVALID"),
    SCORE_BOARD_ID_INVALID("SCORE_BOARD_ID_INVALID", "SCORE BOARD ID IS INVALID"),
    FEE_INVALID("FEE_INVALID", "FEE IS INVALID"),
    FIRST_NAME_INVALID("FIRST_NAME_INVALID", "FIRST NAME IS INVALID"),
    LAST_NAME_INVALID("LAST_NAME_INVALID", "LAST NAME IS INVALID"),
    USERNAME_INVALID("USERNAME_INVALID", "USERNAME IS INVALID"),
    EMAIL_INVALID("EMAIL_INVALID", "EMAIL IS INVALID"),
    EMAIL_EMPTY("EMAIL_EMPTY", "EMAIL IS EMPTY"),
    PASSWORD_EMPTY("PASSWORD_INVALID", "PASSWORD IS EMPTY"),
    LIST_EMPTY("LIST_EMPTY", "LIST OF STUDENTS IS EMPTY");


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
