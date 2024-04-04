package com.love2code.springcoredemo.common;

import com.love2code.springcoredemo.common.Coach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkOut() {
        return "hello";
    }
}
