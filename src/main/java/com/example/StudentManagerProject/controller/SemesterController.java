package com.example.StudentManagerProject.controller;

import com.example.StudentManagerProject.entity.SemesterEntity;
import com.example.StudentManagerProject.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/semesters")
public class SemesterController {

    @Autowired
    private SemesterService service;

    @PostMapping
    public ResponseEntity save (SemesterEntity semester) {
        return service.create(semester);
    }

    @GetMapping
    public ResponseEntity getAll () {
        return service.getAllSemester();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById (@PathVariable Integer id) {
        return service.getSemester(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity update (@PathVariable Integer id, @RequestBody SemesterEntity semesterEntity) {
        return service.update(id, semesterEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable Integer id) {
        return service.delete(id);
    }
}
