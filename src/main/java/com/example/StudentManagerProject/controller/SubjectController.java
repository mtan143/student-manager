package com.example.StudentManagerProject.controller;


import com.example.StudentManagerProject.entity.SubjectEntity;
import com.example.StudentManagerProject.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity save (@RequestBody SubjectEntity subject){

        return ResponseEntity.ok(subjectService.create(subject));
    }

    @GetMapping
    public ResponseEntity getAll () {
        return ResponseEntity.ok(subjectService.getAllSubjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById (@PathVariable Integer id){
        return subjectService.getSubject(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity update (@PathVariable Integer id, @RequestBody SubjectEntity subjectEntity) {
        return subjectService.updateSubject(id, subjectEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable Integer id) {
        return subjectService.delete(id);
    }
}
