package com.example.Security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Security.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByNameContainingIgnoreCase(String name);

    List<Student> findByCity(String city);

}
