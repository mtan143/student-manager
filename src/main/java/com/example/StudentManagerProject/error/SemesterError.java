package com.example.StudentManagerProject.error;

import com.example.StudentManagerProject.exception.BaseError;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum SemesterError implements BaseError {

    SEMESTER("SEMESTER_INVALID", "SEMESTER IS NULL"),
    SEMESTER_ID("SEMESTER_ID", "SEMESTER ID IS NULL"),
    SEMESTER_NOT_EXIST("SEMESTER_NOT_EXIST", "SEMESTER IS NOT EXISTING"),
    YEAR_INVALID("YEAR_INVALID_INVALID", "YEAR IS INVALID"),
    LIST_EMPTY("LIST_EMPTY", "LIST SEMESTER IS EMPTY");


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
