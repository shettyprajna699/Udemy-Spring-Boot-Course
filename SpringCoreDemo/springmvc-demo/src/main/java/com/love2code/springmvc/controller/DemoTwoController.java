package com.love2code.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DemoTwoController {
@RequestMapping("/processview")
    public String showData(HttpServletRequest request, Model model){
        String theName=request.getParameter("studentName");
        theName=theName.toUpperCase();
        String result="hii"+theName;
        model.addAttribute("mesaage",result);
        return "helloworld2";

    }
    @RequestMapping("/pp")
    public String processForm(@RequestParam("studentName") String theName, Model model){
    theName= theName.toUpperCase();
    String rs="hello"+theName;
    model.addAttribute("ms",rs);
    return "helloworld2";

    }
}
