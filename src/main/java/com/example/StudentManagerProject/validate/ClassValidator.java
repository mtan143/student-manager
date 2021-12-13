package com.example.StudentManagerProject.validate;

import com.example.StudentManagerProject.entity.ClassEntity;
import com.example.StudentManagerProject.error.ClassError;
import com.example.StudentManagerProject.exception.BusinessException;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@UtilityClass
public class ClassValidator {
    
    public void validate(ClassEntity classEntity) {

        if (Objects.isNull(classEntity)) {
            throw new BusinessException(ClassError.CLASS);
        }

        if (Objects.isNull(classEntity.getId())) {
            throw new BusinessException(ClassError.CLASS_ID);
        }

        if (StringUtils.isEmpty(classEntity.getName())) {
            throw new BusinessException(ClassError.CLASS_NAME_INVALID);
        }

        if (classEntity.getYear() < 2000) {
            throw new BusinessException(ClassError.YEAR_INVALID);
        }

        if (classEntity.getQuantity() < 30) {
            throw new BusinessException(ClassError.QUANTITY_INVALID);
        }

        if (Objects.isNull(classEntity.getTeacherId()) || classEntity.getTeacherId() < 1) {
            throw new BusinessException(ClassError.TEACHER_ID_INVALID);
        }
    }
}
