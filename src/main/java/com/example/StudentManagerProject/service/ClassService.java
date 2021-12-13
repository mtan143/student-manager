package com.example.StudentManagerProject.service;

import com.example.StudentManagerProject.entity.ClassEntity;
import com.example.StudentManagerProject.error.ClassError;
import com.example.StudentManagerProject.exception.BusinessException;
import com.example.StudentManagerProject.exception.GlobalExceptionHandler;
import com.example.StudentManagerProject.repo.ClassRepo;
import com.example.StudentManagerProject.validate.ClassValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class ClassService {

    @Autowired
    private ClassRepo classRepo;

    /**
     * Create new class
     * @param classEntity
     * @return */
    public ResponseEntity<ClassEntity> create(ClassEntity classEntity){
        ClassValidator.validate(classEntity);
        return new ResponseEntity<>(classRepo.save(classEntity), HttpStatus.CREATED);
    }

    /**
     * Get all classes from db
     * @return
     */
    public ResponseEntity getAllClasses(){

        if (classRepo.findAll().isEmpty())
            throw new BusinessException(ClassError.LIST_EMPTY);

        return new ResponseEntity<>(classRepo.findAll(), HttpStatus.OK);
    }

    /**
     * Get class by classId
     * @param id
     * @return
     */
    public ResponseEntity<ClassEntity> getClass(Integer id){
        if (!classRepo.existsById(id))
            throw new BusinessException(ClassError.CLASS_NOT_EXIST);
        return new ResponseEntity<>(classRepo.findById(id).get(), HttpStatus.OK);
    }

    /**
     * Update a class
     * @param id
     * @param classEntity
     * @return
     */
    public ResponseEntity<ClassEntity> updateClass(Integer id, ClassEntity classEntity) {

        ClassEntity newClass = classRepo.findById(id).get();

        if (Objects.isNull(newClass)) {
            throw new BusinessException(ClassError.CLASS_ID);
        }

        ClassValidator.validate(classEntity);

        newClass.setName(classEntity.getName());
        newClass.setYear(classEntity.getYear());
        newClass.setQuantity(classEntity.getQuantity());
        newClass.setTeacherId(classEntity.getTeacherId());
        return new ResponseEntity<>(classRepo.save(newClass), HttpStatus.OK);
    }

    /**
     * Delete class by id
     * @param id
     * @return
     */
    public ResponseEntity delete (Integer id) {

        ClassEntity classEntity = classRepo.getById(id);
        if (Objects.isNull(classEntity)) throw new BusinessException(ClassError.CLASS_ID);

        classRepo.deleteById(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Find class by year
     * @param year
     * @return
     */
    public ResponseEntity<ClassEntity> findClassByYear(Integer year) {

        if (year < 2000) throw new BusinessException(ClassError.YEAR_INVALID);

        return ResponseEntity.ok(classRepo.findClassEntityByYear(year));
    }
}
