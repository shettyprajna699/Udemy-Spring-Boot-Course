package com.love2code.springboot.rest;

import com.love2code.springboot.entity.Employee;
import com.love2code.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;
// expose "/employess and return a list of employees
    @GetMapping("/emp")
    public List<Employee> findAll() {
       return  employeeService.findAll();
    }
    //add mapping for get/employees/employeeId
    @GetMapping("/emp/{empId}")
    public Employee findById(@PathVariable int empId){
        Employee theEmployee=employeeService.findById(empId);
        if(theEmployee==null){
            throw new RuntimeException("Employee Id not Found -:"+empId);
        }
        return theEmployee;
    }
    @PostMapping("/addEmp")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //also just in case they pass an id in JSON..set id to 0
        //this is to force a save of item... instead of update
        theEmployee.setId(0);
        return employeeService.save(theEmployee);
    }
    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        return employeeService.save(theEmployee);
    }
    @DeleteMapping("/emp/{empId}")
    public String deleteEmployee(@PathVariable int empId){
        Employee employee=employeeService.findById(empId);
        employeeService.deleteById(empId);
        return "Deleted Employee Id; "+empId;

    }

}
