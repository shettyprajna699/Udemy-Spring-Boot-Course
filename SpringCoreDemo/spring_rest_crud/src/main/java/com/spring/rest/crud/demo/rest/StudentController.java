package com.spring.rest.crud.demo.rest;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/test")
@RestController
public class StudentController {

    private List<Student> theStudent;
    @PostConstruct
    public void init(){
        theStudent=new ArrayList<>();
        theStudent.add(new Student(1,"abhinav","rav"));
        theStudent.add(new Student(2,"megha","jain"));
        theStudent.add(new Student(3,"sussi","kumai"));
    }
    @GetMapping("/hello")
    public List<Student> getStudentData(){
        return theStudent;


    }
    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if((studentId>=theStudent.size())||studentId<0){
            throw new StudentNotFoundException("Student not found- "+studentId);

        }


        return theStudent.get(studentId);
    }
//Add an exception handler using @exceptionhandler

}
