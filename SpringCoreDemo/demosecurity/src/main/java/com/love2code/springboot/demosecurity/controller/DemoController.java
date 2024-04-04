package com.love2code.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String homePage(){
        return "home";
    }

    @GetMapping("/leaders")
    public String showLeadersPage(){
        return "leaders-page";
    }
    @GetMapping("/systems")
    public String  showSystemPage(){
        return "systems-page";
    }
}
