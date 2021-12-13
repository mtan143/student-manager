package com.example.StudentManagerProject.validate;
import com.example.StudentManagerProject.entity.ScoreBoardEntity;
import com.example.StudentManagerProject.error.ClassError;
import com.example.StudentManagerProject.error.ScoreBoardError;
import com.example.StudentManagerProject.exception.BusinessException;
import lombok.experimental.UtilityClass;

import java.util.Objects;

@UtilityClass
public class ScoreBoardValidator {

    public void validate(ScoreBoardEntity scoreBoard) {

        if (Objects.isNull(scoreBoard)) {
            throw new BusinessException(ScoreBoardError.SCORE_BOARD);
        }

        if (Objects.isNull(scoreBoard.getId())) {
            throw new BusinessException(ScoreBoardError.SCORE_BOARD_ID);
        }

        if (Objects.isNull(scoreBoard.getStudentId()) || scoreBoard.getStudentId() < 0) {
            throw new BusinessException(ScoreBoardError.STUDENT_ID_INVALID);
        }

        if (Objects.isNull(scoreBoard.getSubjectId()) || scoreBoard.getSubjectId() < 0) {
            throw new BusinessException(ScoreBoardError.SUBJECT_ID_INVALID);
        }

        if (Objects.isNull(scoreBoard.getSemesterScoreId()) || scoreBoard.getSemesterScoreId() < 0) {
            throw new BusinessException(ScoreBoardError.SEMESTER_SCORE_INVALID);
        }

        if (Objects.isNull(scoreBoard.getFinalScore()) || scoreBoard.getFinalScore() < 0) {
            throw new BusinessException(ClassError.TEACHER_ID_INVALID);
        }
    }
}
