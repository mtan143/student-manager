package com.example.StudentManagerProject.error;

import com.example.StudentManagerProject.exception.BaseError;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum SubjectError implements BaseError {

    SUBJECT("SUBJECT_INVALID", "SUBJECT IS NULL"),
    SUBJECT_ID("SUBJECT_ID", "SUBJECT ID IS NULL"),
    NAME_INVALID("NAME_INVALID", "NAME IS INVALID"),
    LIST_EMPTY("LIST_EMPTY", "LIST SUBJECT IS EMPTY");


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
