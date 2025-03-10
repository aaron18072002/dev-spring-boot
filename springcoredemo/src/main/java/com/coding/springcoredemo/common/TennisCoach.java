package com.coding.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TennisCoach implements Coach {

    public TennisCoach() {
        System.out.println("TennisCoach, " + this.getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "Get a volley backhand";
    }
}
