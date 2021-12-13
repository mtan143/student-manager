package com.example.StudentManagerProject.controller;

import com.example.StudentManagerProject.entity.SemesterScoreEntity;
import com.example.StudentManagerProject.service.SemesterScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/semester-scores")
public class SemesterScoreController {

    @Autowired
    private SemesterScoreService service;

    @PostMapping
    public ResponseEntity save (SemesterScoreEntity semesterScoreEntity) {
        return service.create(semesterScoreEntity);
    }

    @GetMapping
    public ResponseEntity getAll () {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById (@PathVariable Integer id) {
        return service.getSemesterScore(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity update (@PathVariable Integer id, @RequestBody SemesterScoreEntity semesterScoreEntity) {
        return service.update(id, semesterScoreEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable Integer id) {
        return service.delete(id);
    }
}
