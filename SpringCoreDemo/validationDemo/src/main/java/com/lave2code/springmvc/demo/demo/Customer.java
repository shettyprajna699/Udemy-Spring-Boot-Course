package com.lave2code.springmvc.demo.demo;

import com.lave2code.springmvc.demo.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;
    @NotNull(message = "lastName is required")
    @Size(min = 1,message = "lastName is required")
    private String lastName="";
    @NotNull(message = "is required")
    @Min(value=0,message="must be greater than or equal to zero")
    @Max(value=10,message="must be less than or equal to 10")
    private Integer freePass;
    @Pattern(regexp = "[a-zA-Z0-9]{5}",message = "only 5 char/digits")
    private String postalCode;
    @CourseCode(value = "HUV", message="must start with HUV")
    private String courseCode;

    public  Customer(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePass() {
        return freePass;
    }

    public void setFreePass(Integer freePass) {
        this.freePass = freePass;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
