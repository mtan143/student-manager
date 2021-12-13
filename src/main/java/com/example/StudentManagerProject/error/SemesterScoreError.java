package com.example.StudentManagerProject.error;

import com.example.StudentManagerProject.exception.BaseError;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum SemesterScoreError implements BaseError {

    SEMESTER_SCORE("SEMESTER_SCORE_INVALID", "SEMESTER SCORE IS NULL"),
    SEMESTER_SCORE_ID("SEMESTER_SCORE_ID", "SEMESTER SCORE ID IS NULL"),
    SEMESTER_ID_INVALID("SEMESTER_ID_INVALID", "SEMESTER ID IS INVALID"),
    FIFTEEN_SCORE_INVALID("FIFTEEN_SCORE_INVALID", "FIFTEEN SCORE IS INVALID"),
    FORTY_FIVE_SCORE_INVALID("FORTY_FIVE_SCORE_INVALID", "FORTY FIVE SCORE SCORE IS INVALID"),
    MID_SEMESTER_SCORE_INVALID("MID_SEMESTER_SCORE_INVALID", "MID SEMESTER SCORE SCORE IS INVALID"),
    END_SEMESTER_SCORE_INVALID("END_SEMESTER_SCORE_INVALID", "END SEMESTER SCORE SCORE IS INVALID"),
    LIST_EMPTY("LIST_EMPTY", "LIST SEMESTER SCORE IS EMPTY");


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
