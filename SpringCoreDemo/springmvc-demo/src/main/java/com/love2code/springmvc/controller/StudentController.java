package com.love2code.springmvc.controller;

import com.love2code.springmvc.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    List<String> country;
    @Value("${languages}")
    List<String> language;
    @Value("${operas}")
    List<String> operatingSystem;
    @GetMapping("/showsStudentForm")
    public String showForm(Model theModel, Student theStudent) {
        //create a student object
        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("countries",country);
        theModel.addAttribute("languages",language);
        theModel.addAttribute("operas",operatingSystem);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {
        System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());
        return "student-confirmation";
    }
}

