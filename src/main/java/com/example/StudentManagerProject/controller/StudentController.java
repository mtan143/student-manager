package com.example.StudentManagerProject.controller;

import com.example.StudentManagerProject.entity.ScoreBoardEntity;
import com.example.StudentManagerProject.entity.StudentEntity;
import com.example.StudentManagerProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity create (@RequestBody StudentEntity student) {
        return studentService.create(student);
    }

    @GetMapping
    public ResponseEntity getAll () {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id){
        return studentService.getStudent(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody StudentEntity student) {
        return studentService.updateStudent(id, student);
    }

    @GetMapping("/fees/{id}")
    public ResponseEntity getFees(@PathVariable Integer id) {
        return studentService.getFees(id);
    }


}
