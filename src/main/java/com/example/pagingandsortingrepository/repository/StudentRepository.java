package com.example.pagingandsortingrepository.repository;

import com.example.pagingandsortingrepository.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.ArrayList;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

    @Query(value = "select s from Student s join ClassRoom c on s.classRoom.id = c.id where c.name =:name")
    public ArrayList<Student> findByNameContaining(String name);

    @Query(nativeQuery = true, value = "select * from student order by name")
    public Page<Student> findAllOrderbyName(Pageable pageable);}
