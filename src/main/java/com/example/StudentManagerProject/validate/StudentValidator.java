package com.example.StudentManagerProject.validate;

import com.example.StudentManagerProject.common.CommonConstant;
import com.example.StudentManagerProject.entity.ScoreBoardEntity;
import com.example.StudentManagerProject.entity.StudentEntity;
import com.example.StudentManagerProject.error.ClassError;
import com.example.StudentManagerProject.error.ScoreBoardError;
import com.example.StudentManagerProject.error.StudentError;
import com.example.StudentManagerProject.exception.BusinessException;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class StudentValidator {

    public void validate(StudentEntity student) {

        if (Objects.isNull(student)) {
            throw new BusinessException(StudentError.STUDENT);
        }

        if (Objects.isNull(student.getId())) {
            throw new BusinessException(StudentError.STUDENT_ID);
        }

        if (Objects.isNull(student.getClassId()) || student.getClassId() < 0) {
            throw new BusinessException(StudentError.CLASS_ID_INVALID);
        }

        if (Objects.isNull(student.getScoreBoardId()) || student.getScoreBoardId() < 0) {
            throw new BusinessException(StudentError.SCORE_BOARD_ID_INVALID);
        }

        if (Objects.isNull(student.getFees()) || student.getFees() < 0) {
            throw new BusinessException(StudentError.FEE_INVALID);
        }

        if (StringUtils.isEmpty(student.getFirstName())) {
            throw new BusinessException(StudentError.FIRST_NAME_INVALID);
        }

        if (StringUtils.isEmpty(student.getLastName())) {
            throw new BusinessException(StudentError.LAST_NAME_INVALID);
        }

        if (StringUtils.isEmpty(student.getUsername())) {
            throw new BusinessException(StudentError.USERNAME_INVALID);
        }

        if (StringUtils.isEmpty(student.getEmail())) {
            throw new BusinessException(StudentError.EMAIL_EMPTY);
        }

        if (StringUtils.isNoneEmpty(student.getEmail())) {
            Pattern pattern = Pattern.compile(CommonConstant.EMAIL_PATTERN);
            Matcher matcher =pattern.matcher(student.getEmail());

            if (!matcher.matches()) {
                throw new BusinessException(StudentError.EMAIL_INVALID);
            }
        }

        if (StringUtils.isEmpty(student.getPassword())) {
            throw new BusinessException(StudentError.PASSWORD_EMPTY);
        }
    }
}
