package com.explorespring.exploreSP.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "redirect:/user"; // same as return "redirect:user"
    }

    @GetMapping("/user")
    public String user(){
        return "/user";     //same as return "user"
    }

    @GetMapping("/admin")
    public String admin(){
        return "/admin";
    }

//    @GetMapping("/test")
//    public String test(){
//        return ("<h1> Succesful test </h1>");
//    }

}
