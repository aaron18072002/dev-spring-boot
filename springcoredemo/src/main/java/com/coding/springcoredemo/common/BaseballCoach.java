package com.coding.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    public BaseballCoach() {
        System.out.println("BaseballCoach, " + this.getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in practice";
    }

}
