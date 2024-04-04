package com.love2code.springmvc.model;

public class Student {
    private String firstName;
    private String lastName;
    private String country;

    private String favoriteLanguage;
    private String favoriteOS;

    public Student(){

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String getFavoriteOS() {
        return favoriteOS;
    }

    public void setFavoriteOS(String favoriteOS) {
        this.favoriteOS = favoriteOS;
    }
}
