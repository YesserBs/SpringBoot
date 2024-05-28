package com.black.bl.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.black.bl.model.Student;
import com.black.bl.service.StudentService;


@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
}