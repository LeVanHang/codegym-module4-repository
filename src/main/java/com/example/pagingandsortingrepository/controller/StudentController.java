package com.example.pagingandsortingrepository.controller;

import com.example.pagingandsortingrepository.model.ClassRoom;
import com.example.pagingandsortingrepository.model.Student;
import com.example.pagingandsortingrepository.service.IClassRoomService;
import com.example.pagingandsortingrepository.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    IStudentService studentService;

    @Autowired
    IClassRoomService classRoomService;

    @GetMapping("/students")
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("students",studentService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("student",new Student());
        modelAndView.addObject("classRoom", classRoomService.findAll());
        return modelAndView;
    }

    @ModelAttribute("student")
    public Student student() {

        return new Student();
    }

    @ModelAttribute("classRooms")
    public List<ClassRoom> classRooms() {

        return classRoomService.findAll();
    }

    @PostMapping("/create")
    public String create (@ModelAttribute(value = "student") Student student, @RequestParam MultipartFile upImg, Long idClassRoom, MultipartFile upFile) {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setId(idClassRoom);
        student.setClassRoom(classRoom);

        String nameFile = upFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(upImg.getBytes(), new File(new File("C:\\CodeGym\\module4\\PagingAndSortingRepository\\src\\main\\webapp\\WEB-INF\\img") + nameFile));
            student.setImg("/img/" + nameFile);
            studentService.save(student);
        } catch (IOException e) {
            student.setImg("/img/![](../../../../../webapp/WEB-INF/img/z3735084593778_275d41cf768499105f769b3d4254a6f4.jpg)");
            studentService.save(student);
            e.printStackTrace();
        }
        return "redirect:/student";
    }

}
