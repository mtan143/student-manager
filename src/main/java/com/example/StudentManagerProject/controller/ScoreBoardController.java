package com.example.StudentManagerProject.controller;


import com.example.StudentManagerProject.entity.ClassEntity;
import com.example.StudentManagerProject.entity.ScoreBoardEntity;
import com.example.StudentManagerProject.service.ClassService;
import com.example.StudentManagerProject.service.ScoreBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scoreboards")
public class ScoreBoardController {

    @Autowired
    private ScoreBoardService scoreBoardService;

    @PostMapping
    public ResponseEntity save(@RequestBody ScoreBoardEntity scoreBoardEntity){
        return scoreBoardService.create(scoreBoardEntity);
    }

    @GetMapping
    public ResponseEntity getAll(){
        return scoreBoardService.getAllScoreBoard();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id){
        return scoreBoardService.getScoreBoard(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScoreBoardEntity> update(@PathVariable Integer id, @RequestBody ScoreBoardEntity scoreBoardEntity) {
        return scoreBoardService.updateScoreBoard(id, scoreBoardEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable Integer id) {
        return scoreBoardService.delete(id);
    }
}
