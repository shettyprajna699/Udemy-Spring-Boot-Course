package com.love2code.springcoredemo.common;

import com.love2code.springcoredemo.common.Coach;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    @Override
    public String getDailyWorkOut() {
        return "am a Tennis Coach";
    }
}
