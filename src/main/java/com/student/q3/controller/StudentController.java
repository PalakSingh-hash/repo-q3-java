package com.student.q3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.student.q3.model.Student;
import com.student.q3.service.StudentService;
import com.student.q3.dto.PerformanceRequest;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {

        return service.addStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {

        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {

        return service.getStudentById(id);
    }


    @PutMapping("/{id}/performance")
    public Student updatePerformance(
            @PathVariable int id,
            @RequestBody PerformanceRequest request) {

        return service.updatePerformance(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {

        return service.deleteStudent(id);
    }

 
    @GetMapping("/merit-list")
    public List<Student> getMeritList() {

        return service.getMeritList();
    }
}