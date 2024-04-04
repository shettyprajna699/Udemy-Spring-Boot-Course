package com.love2code.springcoredemo.controller;

import com.love2code.springcoredemo.common.Coach;
import com.love2code.springcoredemo.common.CricketCoach;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
    private Coach coach;
    private Coach anotherCoach;

    public CoachController(@Qualifier("tennisCoach") Coach coach,
                           @Qualifier("tennisCoach") Coach aCoach
                           ) {
        System.out.println("In constructor: "+getClass().getSimpleName());
        this.coach = coach;
        this.anotherCoach=aCoach;
    }

    @GetMapping("work")
    public String workOut(){

        return coach.getDailyWorkOut();
    }
    @GetMapping("check")
    public String check(){
        return "Comparing beans: coach==anothercoach "+(coach==anotherCoach);
    }

}
