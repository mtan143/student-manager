package com.example.StudentManagerProject.validate;

import com.example.StudentManagerProject.entity.ScoreBoardEntity;
import com.example.StudentManagerProject.entity.SubjectEntity;
import com.example.StudentManagerProject.error.ClassError;
import com.example.StudentManagerProject.error.ScoreBoardError;
import com.example.StudentManagerProject.error.SubjectError;
import com.example.StudentManagerProject.exception.BusinessException;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@UtilityClass
public class SubjectValidator {

    public void validate(SubjectEntity subject) {

        if (Objects.isNull(subject)) {
            throw new BusinessException(SubjectError.SUBJECT);
        }

        if (Objects.isNull(subject.getId())) {
            throw new BusinessException(SubjectError.SUBJECT_ID);
        }

        if (StringUtils.isEmpty(subject.getName())) {
            throw new BusinessException(SubjectError.NAME_INVALID);
        }
    }
}
