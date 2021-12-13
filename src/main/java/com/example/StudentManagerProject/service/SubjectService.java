package com.example.StudentManagerProject.service;

import com.example.StudentManagerProject.entity.SubjectEntity;
import com.example.StudentManagerProject.error.SubjectError;
import com.example.StudentManagerProject.exception.BusinessException;
import com.example.StudentManagerProject.repo.SubjectRepo;
import com.example.StudentManagerProject.validate.SubjectValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepo subjectRepo;

    /**
     * Create new subject
     * @param subject
     * @return
     */
    public ResponseEntity create(SubjectEntity subject){
        SubjectValidator.validate(subject);

        return ResponseEntity.ok(subjectRepo.save(subject));

    }

    /**
     * Get all subject from db
     * @return
     */
    public ResponseEntity getAllSubjects(){

        if (subjectRepo.findAll().isEmpty()) throw new BusinessException(SubjectError.LIST_EMPTY);

        return ResponseEntity.ok(subjectRepo.findAll());
    }

    /**
     * Get subject by id
     * @param id
     * @return
     */
    public ResponseEntity getSubject(Integer id){

        if (Objects.isNull(id)) throw new BusinessException(SubjectError.SUBJECT_ID);

        SubjectEntity subjectEntity = subjectRepo.getById(id);
        if (Objects.isNull(subjectEntity)) throw new BusinessException(SubjectError.SUBJECT);

        return ResponseEntity.ok(subjectEntity);
    }

    /**
     * Update a subject
     * @param id
     * @param subject
     * @return
     */
    public ResponseEntity updateSubject(Integer id, SubjectEntity subject) {

        if (Objects.isNull(id)) throw new BusinessException(SubjectError.SUBJECT_ID);

        SubjectEntity subjectEntity = subjectRepo.findById(id).get();
        if (Objects.isNull(subjectEntity)) throw new BusinessException(SubjectError.SUBJECT);

        subjectEntity.setName(subject.getName());

        return ResponseEntity.ok(subjectRepo.save(subjectEntity));
    }

    /**
     * Delete subject by id
     * @param id
     * @return
     */
    public ResponseEntity delete (Integer id) {

        if (Objects.isNull(id)) throw new BusinessException(SubjectError.SUBJECT_ID);
        if (!subjectRepo.existsById(id)) throw new BusinessException(SubjectError.SUBJECT);

        subjectRepo.deleteById(id);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
