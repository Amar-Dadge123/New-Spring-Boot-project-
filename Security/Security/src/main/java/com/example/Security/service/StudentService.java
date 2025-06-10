package com.example.Security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Security.entity.Student;

@Service
public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(int id);

    Student updateStudent(int id, Student student);

    void deleteStudent(int id);

    List<Student> findByCity(String city);

    List<Student> findByName(String name);

    void deleteAllStudents();

    List<Student> saveAllStudents(List<Student> students);

    long countStudents();
}
