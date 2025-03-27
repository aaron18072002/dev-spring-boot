package com.coding.thymeleafdemo.controller;

import com.coding.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${favouriteLanguages}")
    private List<String> favouriteLanguages;

    @Value("${systems}")
    private List<String> favouriteSystems;

    @GetMapping("/showStudentForm")
    public String showStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("countries", this.countries);
        model.addAttribute("favouriteLanguages", this.favouriteLanguages);
        model.addAttribute("favouriteSystems", this.favouriteSystems);

        return "studentForm";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute(name = "student")Student student) {
        System.out.println(student);

        return "studentConfirmation";
    }

}
