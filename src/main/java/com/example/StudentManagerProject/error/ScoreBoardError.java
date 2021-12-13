package com.example.StudentManagerProject.error;

import com.example.StudentManagerProject.exception.BaseError;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum ScoreBoardError implements BaseError {
    SCORE_BOARD("SCORE_BOARD_INVALID", "SCORE BOARD IS NULL"),
    SCORE_BOARD_ID("SCORE_BOARD_ID", "SCORE BOARD ID IS NULL"),
    SCORE_BOARD_NOT_EXIST("SCORE_BOARD_NOT_EXIST", "SCORE BOARD IS NOT EXISTING"),
    STUDENT_ID_INVALID("STUDENT_ID_INVALID", "STUDENT ID IS INVALID"),
    SUBJECT_ID_INVALID("SUBJECT_ID_INVALID", "SUBJECT ID IS INVALID"),
    SEMESTER_SCORE_INVALID("SEMESTER_SCORE", "SEMESTER SCORE IS INVALID"),
    FINAL_SCORE_INVALID("FINAL_SCORE_INVALID", "FINAL SCORE IS INVALID"),
    LIST_EMPTY("LIST_EMPTY", "LIST SCORE BOARD IS EMPTY");


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
