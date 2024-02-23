package com.student.service;

import com.student.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private static StudentService instance;
    private List<Student> students;
    private long nextId;

    private StudentService() {
        students = new ArrayList<>();
        nextId = 1;
    }

    public static synchronized StudentService getInstance() {
        if (instance == null) {
            instance = new StudentService();
        }
        return instance;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public Student getStudentById(long id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void addStudent(Student student) {
        student.setId(nextId++);
        students.add(student);
    }

    public void updateStudent(Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getId() == updatedStudent.getId()) {
                students.set(i, updatedStudent);
                return;
            }
        }
    }

    public void deleteStudent(long id) {
        students.removeIf(student -> student.getId() == id);
    }
}
