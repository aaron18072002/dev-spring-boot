package com.coding.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

//    @RequestMapping("/processFormVersionTwo")
//    public String letsShoutDute(HttpServletRequest request, Model model) {
//        String userName = request.getParameter("userName");
//        model.addAttribute("userName", userName);
//
//        String message = "YO! " + userName.toUpperCase();
//        model.addAttribute("message", message);
//
//        return "helloWorld";
//    }
//
//    @RequestMapping(name = "processFormVersionThree", method = RequestMethod.GET)
//    public String processFormVersionThree(
//            @RequestParam(name = "userName") String userName, Model model) {
//        model.addAttribute("userName", userName);
//
//        String message = "YO! " + userName.toUpperCase();
//        model.addAttribute("message", message);
//
//        return "helloWorld";
//    }

}
