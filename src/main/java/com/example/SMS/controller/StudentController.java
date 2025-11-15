package com.example.SMS.controller;

import com.example.SMS.entity.Student;
import com.example.SMS.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Student student) {
        try {
            return new ResponseEntity<>(studentService.add(student), HttpStatus.CREATED);
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAll() {
        try {
            return new ResponseEntity<>(studentService.getAll(),HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getById(id));
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id)
    {
        return ResponseEntity.ok(studentService.deleteById(id));
    }
    @PutMapping("/updateById/{id}")
    public ResponseEntity<String> updateById(@PathVariable long id, @RequestBody Student student ) {
        try {
            return ResponseEntity.ok(studentService.updateById(id, student));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
