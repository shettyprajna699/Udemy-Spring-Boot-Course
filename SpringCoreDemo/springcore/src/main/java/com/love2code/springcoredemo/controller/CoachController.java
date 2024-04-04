package com.love2code.springcoredemo.controller;

import com.love2code.springcoredemo.common.Coach;
import com.love2code.springcoredemo.common.CricketCoach;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
    private Coach coach;

    public CoachController(@Qualifier("tennisCoach") Coach coach) {
        this.coach = coach;
    }

    @GetMapping("work")
    public String workOut(){

        return coach.getDailyWorkOut();
    }

}
