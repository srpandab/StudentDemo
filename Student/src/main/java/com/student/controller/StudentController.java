package com.student.controller;

import com.student.entity.Student;
import com.student.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentDatabase = StudentService.getInstance();

    @GetMapping
    public List<Student> getAllStudents() {
        return studentDatabase.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable long id) {
        return studentDatabase.getStudentById(id);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentDatabase.addStudent(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable long id, @RequestBody Student updatedStudent) {
        updatedStudent.setId(id);
        studentDatabase.updateStudent(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentDatabase.deleteStudent(id);
    }
}
