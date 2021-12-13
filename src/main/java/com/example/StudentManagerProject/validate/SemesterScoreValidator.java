package com.example.StudentManagerProject.validate;
import com.example.StudentManagerProject.entity.SemesterScoreEntity;
import com.example.StudentManagerProject.error.SemesterScoreError;
import com.example.StudentManagerProject.exception.BusinessException;
import lombok.experimental.UtilityClass;

import java.util.Objects;

@UtilityClass
public class SemesterScoreValidator {

    public void validate(SemesterScoreEntity semesterScore) {

        if (Objects.isNull(semesterScore)) {
            throw new BusinessException(SemesterScoreError.SEMESTER_SCORE);
        }

        if (Objects.isNull(semesterScore.getId())) {
            throw new BusinessException(SemesterScoreError.SEMESTER_SCORE_ID);
        }

        if (Objects.isNull(semesterScore.getSemesterId()) || semesterScore.getSemesterId() < 0) {
            throw new BusinessException(SemesterScoreError.SEMESTER_ID_INVALID);
        }

        if (semesterScore.getFifteenScore() > 10 || semesterScore.getFifteenScore() < 0) {
            throw new BusinessException(SemesterScoreError.FIFTEEN_SCORE_INVALID);
        }

        if (semesterScore.getFortyFiveScore() > 10 || semesterScore.getFortyFiveScore() < 0) {
            throw new BusinessException(SemesterScoreError.FORTY_FIVE_SCORE_INVALID);
        }

        if (semesterScore.getMidSemesterScore() > 10 || semesterScore.getMidSemesterScore() < 0) {
            throw new BusinessException(SemesterScoreError.MID_SEMESTER_SCORE_INVALID);
        }

        if (semesterScore.getEndSemesterScore() > 10 || semesterScore.getEndSemesterScore() < 0) {
            throw new BusinessException(SemesterScoreError.END_SEMESTER_SCORE_INVALID);
        }
    }
}
