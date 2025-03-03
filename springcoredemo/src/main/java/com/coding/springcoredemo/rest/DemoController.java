package com.coding.springcoredemo.rest;

import com.coding.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach coach;
    private Coach anotherCoach;

    // constructor injection
    @Autowired
    public DemoController(@Qualifier("tennisCoach") Coach coach,
                          @Qualifier("tennisCoach") Coach anotherCoach) {
        System.out.println("DemoController, " + this.getClass().getName());
        this.coach = coach;
        this.anotherCoach = anotherCoach;
    }

    // setter injection
//    @Autowired
//    public void setCoach(Coach coach) {
//        this.coach = coach;
//    }

    @GetMapping("/")
    public String get() {
        return this.coach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "comparing 2 beans ," + (this.coach == this.anotherCoach);
    }

}
