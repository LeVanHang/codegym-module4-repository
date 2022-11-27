package com.example.pagingandsortingrepository.service;

import com.example.pagingandsortingrepository.model.ClassRoom;
import com.example.pagingandsortingrepository.repository.ClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassRoomService implements IClassRoomService{

    @Autowired
    ClassRoomRepository classRoomRepository;

    @Override
    public List<ClassRoom> findAll() {
        return (List<ClassRoom>) classRoomRepository.findAll();
    }

    public ClassRoom findById(Long id) {
        return classRoomRepository.findById(id).get();
    }




}
