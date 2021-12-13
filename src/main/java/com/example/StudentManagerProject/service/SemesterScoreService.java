package com.example.StudentManagerProject.service;

import com.example.StudentManagerProject.entity.ScoreBoardEntity;
import com.example.StudentManagerProject.entity.SemesterScoreEntity;
import com.example.StudentManagerProject.error.ScoreBoardError;
import com.example.StudentManagerProject.error.SemesterScoreError;
import com.example.StudentManagerProject.exception.BusinessException;
import com.example.StudentManagerProject.repo.SemesterScoreRepo;
import com.example.StudentManagerProject.validate.SemesterScoreValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
public class SemesterScoreService {

    @Autowired
    private SemesterScoreRepo semesterScoreRepo;

    /**
     * Create new semester score for student
     * @param semesterScore
     * @return
     */
    public ResponseEntity create (SemesterScoreEntity semesterScore) {
        SemesterScoreValidator.validate(semesterScore);

        return ResponseEntity.ok(semesterScoreRepo.save(semesterScore));
    }

    /**
     * Get all semester score from db
     * @return
     */
    public ResponseEntity getAll () {

        if (semesterScoreRepo.findAll().isEmpty()) throw new BusinessException(SemesterScoreError.LIST_EMPTY);

        return ResponseEntity.ok(semesterScoreRepo.findAll().isEmpty());
    }

    /**
     * Get semester score by id
     * @param id
     * @return
     */
    public ResponseEntity getSemesterScore (Integer id) {
        if (!semesterScoreRepo.existsById(id))
            throw new BusinessException(SemesterScoreError.SEMESTER_SCORE_ID);

        return ResponseEntity.ok(semesterScoreRepo.findById(id).get());
    }

    /**
     * Update a semesterscore
     * @param id
     * @param semesterScore
     * @return
     */
    public ResponseEntity update(Integer id, SemesterScoreEntity semesterScore) {

        SemesterScoreEntity _semesterScore = semesterScoreRepo.findById(id).get();

        if (Objects.isNull(_semesterScore)) {
            throw new BusinessException(SemesterScoreError.SEMESTER_SCORE);
        }

        _semesterScore.setSemesterId(semesterScore.getSemesterId());
        _semesterScore.setFifteenScore(semesterScore.getFifteenScore());
        _semesterScore.setFortyFiveScore(semesterScore.getFortyFiveScore());
        _semesterScore.setMidSemesterScore(semesterScore.getMidSemesterScore());
        _semesterScore.setEndSemesterScore(semesterScore.getEndSemesterScore());


        return ResponseEntity.ok(semesterScoreRepo.save(_semesterScore));
    }

    /**
     * Delete by id
     * @param id
     * @return
     */
    public ResponseEntity delete (Integer id) {
        SemesterScoreEntity semesterScoreEntity = semesterScoreRepo.getById(id);

        if (Objects.isNull(semesterScoreEntity)) {
            throw new BusinessException(SemesterScoreError.SEMESTER_SCORE_ID);
        }

        semesterScoreRepo.delete(semesterScoreEntity);

        return new ResponseEntity(HttpStatus.OK);
    }

}
