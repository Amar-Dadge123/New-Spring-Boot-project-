package com.example.Security.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Security.entity.Student;
import com.example.Security.repository.StudentRepository;
import com.example.Security.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    StudentServiceImpl(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(int id, Student updatedStudent) {
        Optional<Student> existing = studentRepository.findById(id);
        if (existing.isPresent()) {
            Student student = existing.get();
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setCity(updatedStudent.getCity());
            return studentRepository.save(student);
        }
        return null;
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findByCity(String city) {
        return studentRepository.findByCity(city);
    }

    @Override
    public List<Student> findByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }

    @Override
    public List<Student> saveAllStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    @Override
    public long countStudents() {
        return studentRepository.count();
    }

}
