package com.coding.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TrackCoach implements Coach {

    public TrackCoach() {
        System.out.println("Track Coach, " + this.getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }
}
