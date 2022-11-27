package com.example.pagingandsortingrepository.service;

import com.example.pagingandsortingrepository.model.Student;
import com.example.pagingandsortingrepository.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StudentService implements IStudentService{

    @Autowired
    StudentRepository studentRepository;


    @Override
    public List<Student> findAll() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Optional findById(long id) {
        return studentRepository.findById(id);
    }
}
