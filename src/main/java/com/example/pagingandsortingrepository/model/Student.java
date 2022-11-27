package com.example.pagingandsortingrepository.model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String img;
    private int ClassRoom;

    @ManyToOne
    private ClassRoom classRoom;

    public Student() {
    }

    public Student(Long id, String name, int age, String img, int classRoom, com.example.pagingandsortingrepository.model.ClassRoom classRoom1) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.img = img;
        ClassRoom = classRoom;
        this.classRoom = classRoom1;
    }

    public Student(String name, int age, String img, int classRoom, com.example.pagingandsortingrepository.model.ClassRoom classRoom1) {
        this.name = name;
        this.age = age;
        this.img = img;
        ClassRoom = classRoom;
        this.classRoom = classRoom1;
    }

    public Student(Long id, String name, int age, String img, int classRoom) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.img = img;
        ClassRoom = classRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getClassRoom() {
        return ClassRoom;
    }

    public void setClassRoom(com.example.pagingandsortingrepository.model.ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public void setClassRoom(int classRoom) {
        ClassRoom = classRoom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
