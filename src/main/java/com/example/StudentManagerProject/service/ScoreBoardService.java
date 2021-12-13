package com.example.StudentManagerProject.service;

import com.example.StudentManagerProject.entity.ScoreBoardEntity;
import com.example.StudentManagerProject.error.ScoreBoardError;
import com.example.StudentManagerProject.exception.BusinessException;
import com.example.StudentManagerProject.repo.ScoreBoardRepo;
import com.example.StudentManagerProject.validate.ScoreBoardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ScoreBoardService {

    @Autowired
    private ScoreBoardRepo scoreBoardRepo;

    /**
     * Create new scoreboard for student
     * @param scoreBoardEntity
     * @return
     */
    public ResponseEntity create(ScoreBoardEntity scoreBoardEntity){

        ScoreBoardValidator.validate(scoreBoardEntity);
        return ResponseEntity.ok(scoreBoardRepo.save(scoreBoardEntity));
    }

    /**
     * Get all scoreboard from db
     * @return
     */
    public ResponseEntity getAllScoreBoard(){

        if (scoreBoardRepo.findAll().isEmpty()) throw new BusinessException(ScoreBoardError.LIST_EMPTY);

        return ResponseEntity.ok(scoreBoardRepo.findAll());
    }


    /**
     * Get scoreboard by id
     * @param id
     * @return
     */
    public ResponseEntity getScoreBoard (Integer id) {

        if (!scoreBoardRepo.existsById(id))
            throw new BusinessException(ScoreBoardError.SCORE_BOARD);

        return ResponseEntity.ok(scoreBoardRepo.findById(id).get());
    }


    /**
     * Update a scoreboad
     * @param id
     * @param scoreBoard
     * @return
     */
    public ResponseEntity<ScoreBoardEntity> updateScoreBoard(Integer id, ScoreBoardEntity scoreBoard) {

        Optional<ScoreBoardEntity> scoreBoardEntity = scoreBoardRepo.findById(id);

        if (Objects.isNull(scoreBoardEntity)) {
            throw new BusinessException(ScoreBoardError.SCORE_BOARD);
        }

        ScoreBoardEntity _scoreBoard = scoreBoardEntity.get();

        _scoreBoard.setStudentId(scoreBoard.getStudentId());
        _scoreBoard.setSubjectId(scoreBoard.getSubjectId());
        _scoreBoard.setSemesterScoreId(scoreBoard.getSemesterScoreId());
        _scoreBoard.setFinalScore(scoreBoard.getFinalScore());

        return new ResponseEntity<>(scoreBoardRepo.save(_scoreBoard), HttpStatus.OK);
    }

    /**
     * Delete by id
     * @param id
     * @return
     */
    public ResponseEntity delete (Integer id) {
        ScoreBoardEntity scoreBoardEntity = scoreBoardRepo.getById(id);

        if (Objects.isNull(scoreBoardEntity)) {
            throw new BusinessException(ScoreBoardError.SCORE_BOARD);
        }

        scoreBoardRepo.delete(scoreBoardEntity);

        return new ResponseEntity(HttpStatus.OK);
    }

}
