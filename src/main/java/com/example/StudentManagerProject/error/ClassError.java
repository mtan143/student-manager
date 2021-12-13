package com.example.StudentManagerProject.error;

import com.example.StudentManagerProject.exception.BaseError;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum ClassError implements BaseError {

    CLASS("CLASS_INVALID", "CLASS IS NULL"),
    CLASS_ID("CLASS_ID", "CLASS ID IS NULL"),
    CLASS_NOT_EXIST("CLASS_NOT_EXIST", "CLASS IS NOT EXISTING"),
    CLASS_NAME_INVALID("CLASS_NAME_INVALID", "CLASS NAME IS INVALID"),
    YEAR_INVALID("YEAR_INVALID", "CLASS YEAR IS INVALID"),
    QUANTITY_INVALID("QUANTITY_INVALID", "QUANTITY IS INVALID"),
    TEACHER_ID_INVALID("TEACHER_ID_INVALID", "TEACHER ID IS INVALID"),
    LIST_EMPTY("LIST_EMPTY", "LIST CLASS IS EMPTY");


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
