package com.example.StudentManagerProject.controller;


import com.example.StudentManagerProject.entity.ClassEntity;
import com.example.StudentManagerProject.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @PostMapping
    public ResponseEntity<ClassEntity> save(@RequestBody ClassEntity classEntity){
        return classService.create(classEntity);
    }

    @GetMapping
    public ResponseEntity getAll(){
        return classService.getAllClasses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassEntity> getById(@PathVariable Integer id){
        return classService.getClass(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassEntity> update(@PathVariable Integer id,
                                              @RequestBody ClassEntity classEntity) {
        return classService.updateClass(id, classEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable Integer id) {
        return classService.delete(id);
    }

    @GetMapping("/years/{year}")
    public ResponseEntity<ClassEntity> findClassByYear(@PathVariable Integer year) {
        return classService.findClassByYear(year);
    }

}
