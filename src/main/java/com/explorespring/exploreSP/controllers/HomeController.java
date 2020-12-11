package com.explorespring.exploreSP.controllers;


import com.explorespring.exploreSP.auth.model.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    UserRepository userRepository;

    //constructors r @Autowired
    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
