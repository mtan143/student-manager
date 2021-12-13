package com.example.StudentManagerProject.validate;

import com.example.StudentManagerProject.common.CommonConstant;
import com.example.StudentManagerProject.entity.ScoreBoardEntity;
import com.example.StudentManagerProject.entity.TeacherEntity;
import com.example.StudentManagerProject.error.ClassError;
import com.example.StudentManagerProject.error.ScoreBoardError;
import com.example.StudentManagerProject.error.StudentError;
import com.example.StudentManagerProject.error.TeacherError;
import com.example.StudentManagerProject.exception.BusinessException;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class TeacherValidator {

    public void validate(TeacherEntity teacher) {

        if (Objects.isNull(teacher)) {
            throw new BusinessException(TeacherError.TEACHER);
        }

        if (Objects.isNull(teacher.getId())) {
            throw new BusinessException(TeacherError.TEACHER_ID);
        }

        if (StringUtils.isEmpty(teacher.getIdCard())) {
            throw new BusinessException(TeacherError.CARD_ID_INVALID);
        }

        if (Objects.isNull(teacher.getSalary()) || teacher.getSalary() < 0L) {
            throw new BusinessException(TeacherError.SALARY_INVALID);
        }

        if (StringUtils.isEmpty(teacher.getFirstName())) {
            throw new BusinessException(StudentError.FIRST_NAME_INVALID);
        }

        if (StringUtils.isEmpty(teacher.getLastName())) {
            throw new BusinessException(StudentError.LAST_NAME_INVALID);
        }

        if (StringUtils.isEmpty(teacher.getUsername())) {
            throw new BusinessException(StudentError.USERNAME_INVALID);
        }

        if (StringUtils.isEmpty(teacher.getEmail())) {
            throw new BusinessException(StudentError.EMAIL_EMPTY);
        }

        if (StringUtils.isNoneEmpty(teacher.getEmail())) {
            Pattern pattern = Pattern.compile(CommonConstant.EMAIL_PATTERN);
            Matcher matcher =pattern.matcher(teacher.getEmail());

            if (!matcher.matches()) {
                throw new BusinessException(StudentError.EMAIL_INVALID);
            }
        }

        if (StringUtils.isEmpty(teacher.getPassword())) {
            throw new BusinessException(StudentError.PASSWORD_EMPTY);
        }
    }
}
