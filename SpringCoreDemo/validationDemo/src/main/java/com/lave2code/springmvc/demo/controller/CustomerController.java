package com.lave2code.springmvc.demo.controller;

import com.lave2code.springmvc.demo.demo.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

// add an initbinder.. to convert trim input strings
//remove leading and trailing whitespace
//resolve issue for our validation
@Controller
public class CustomerController {
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }
    @GetMapping("/")
    public String showForm(Model theModel, Customer theCustomer){
        theModel.addAttribute("customer",theCustomer);
        return "customer-form";

    }
    @PostMapping ("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult bindingResult
            ){
        System.out.println("Last Name: |"+theCustomer.getLastName()+"|");
        System.out.println("Binding results: "+ bindingResult.toString());
        System.out.println("\n\n\n\n");
        if(bindingResult.hasErrors()){
            return "customer-form";
        }
        else{
            return "customer-confirm";
        }

    }
}
