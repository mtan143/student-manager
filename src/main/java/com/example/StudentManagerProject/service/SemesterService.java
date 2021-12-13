package com.example.StudentManagerProject.service;

import com.example.StudentManagerProject.entity.SemesterEntity;
import com.example.StudentManagerProject.error.SemesterError;
import com.example.StudentManagerProject.exception.BusinessException;
import com.example.StudentManagerProject.repo.SemesterRepo;
import com.example.StudentManagerProject.validate.SemesterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
public class SemesterService {

    @Autowired
    private SemesterRepo semesterRepo;

    /**
     * Create new semester
     * @param semester
     * @return
     */
    public ResponseEntity create(SemesterEntity semester){

        SemesterValidator.validate(semester);
        return ResponseEntity.ok(semesterRepo.save(semester));
    }

    /**
     * Get all semester from db
     * @return
     */
    public ResponseEntity getAllSemester(){

        if (semesterRepo.findAll().isEmpty()) throw new BusinessException(SemesterError.LIST_EMPTY);

        return ResponseEntity.ok(semesterRepo.findAll());
    }


    /**
     * Get semester by id
     * @param id
     * @return
     */
    public ResponseEntity getSemester (Integer id) {

        if (!semesterRepo.existsById(id))
            throw new BusinessException(SemesterError.SEMESTER_ID);

        return ResponseEntity.ok(semesterRepo.findById(id).get());
    }


    /**
     * Update a semester
     * @param id
     * @param semester
     * @return
     */
    public ResponseEntity update(Integer id, SemesterEntity semester) {

        Optional<SemesterEntity> semesterEntity = semesterRepo.findById(id);

        if (Objects.isNull(semesterEntity)) {
            throw new BusinessException(SemesterError.SEMESTER);
        }

        SemesterEntity _semester = semesterEntity.get();

        _semester.setYear(semester.getYear());

        return ResponseEntity.ok(semesterRepo.save(_semester));
    }

    /**
     * Delete by id
     * @param id
     * @return
     */
    public ResponseEntity delete (Integer id) {
        SemesterEntity semesterEntity = semesterRepo.getById(id);

        if (Objects.isNull(semesterEntity)) {
            throw new BusinessException(SemesterError.SEMESTER);
        }

        semesterRepo.delete(semesterEntity);

        return new ResponseEntity(HttpStatus.OK);
    }
}
