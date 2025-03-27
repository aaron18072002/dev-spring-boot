package com.coding.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/helloworld")
    public String helloword(Model model) {
        model.addAttribute("now", java.time.LocalDate.now().toString());

        return "helloworld";
    }

    @GetMapping("/showForm")
    public String showForm(Model model) {
        return "form";
    }

    @GetMapping("/processForm")
    public String processForm(Model model) {
        return "processForm";
    }

}
