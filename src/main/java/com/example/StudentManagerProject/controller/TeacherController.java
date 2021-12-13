package com.example.StudentManagerProject.controller;


import com.example.StudentManagerProject.entity.TeacherEntity;
import com.example.StudentManagerProject.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public ResponseEntity save (@RequestBody TeacherEntity teacher) {

        return ResponseEntity.ok(teacherService.create(teacher));
    }

    @GetMapping
    public ResponseEntity getAll () {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById (@PathVariable Integer id) {
        return teacherService.getTeacher(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity update (@PathVariable Integer id, @RequestBody TeacherEntity teacher) {
        return teacherService.updateTeacher(id, teacher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable Integer id) {
        return teacherService.delete(id);
    }
}
