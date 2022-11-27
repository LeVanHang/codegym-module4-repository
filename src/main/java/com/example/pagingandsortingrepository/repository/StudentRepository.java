package com.example.pagingandsortingrepository.repository;

import com.example.pagingandsortingrepository.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long> {
}
