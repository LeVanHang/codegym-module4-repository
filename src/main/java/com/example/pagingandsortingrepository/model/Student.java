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

    @ManyToOne
    private ClassRoom classRoom;

    public Student() {
    }

    public Student(Long id, String name, int age, String img, ClassRoom classRoom) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.img = img;
        this.classRoom = classRoom;
    }

    public Student(String name, int age, String img, ClassRoom classRoom) {
        this.name = name;
        this.age = age;
        this.img = img;
        this.classRoom = classRoom;
    }

    public Student(Long id, String name, int age, String img) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
