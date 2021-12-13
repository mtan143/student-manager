package com.example.StudentManagerProject.validate;
import com.example.StudentManagerProject.entity.SemesterEntity;
import com.example.StudentManagerProject.error.SemesterError;
import com.example.StudentManagerProject.exception.BusinessException;
import lombok.experimental.UtilityClass;

import java.util.Objects;

@UtilityClass
public class SemesterValidator {

    public void validate(SemesterEntity semester) {

        if (Objects.isNull(semester)) {
            throw new BusinessException(SemesterError.SEMESTER);
        }

        if (Objects.isNull(semester.getId())) {
            throw new BusinessException(SemesterError.SEMESTER_ID);
        }

        if (Objects.isNull(semester.getYear()) || semester.getYear() < 1900) {
            throw new BusinessException(SemesterError.YEAR_INVALID);
        }
    }
}
