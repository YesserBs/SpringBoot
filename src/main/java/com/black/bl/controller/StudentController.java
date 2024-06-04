package com.black.bl.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.black.bl.model.Student;
import com.black.bl.service.StudentService;


@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Read
    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    // Create
    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    // Update
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    // Delete
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}