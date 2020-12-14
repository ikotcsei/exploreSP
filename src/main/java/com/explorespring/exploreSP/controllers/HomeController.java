package com.explorespring.exploreSP.controllers;


import com.explorespring.exploreSP.model.User;
import com.explorespring.exploreSP.repositories.UserRepository;
import com.explorespring.exploreSP.services.UserService;
import com.explorespring.exploreSP.services.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping
@RestController
@Controller
public class HomeController {

//    UserRepository userRepository;
    UserService userService;

    //constructors r @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }




    @GetMapping("/")
    public String home(){
        return "redirect:/user"; // same as return "redirect:user"
    }

    @GetMapping("/user")
    public String user(Model model){
        model.addAttribute("users",userService.getUser());
        return "/user";     //same as return "user"
    }

    @GetMapping("/admin")
    public String admin(){
        return "/admin";
    }

    @GetMapping("/userapi")
    public List<User> getAllUsers(){
        return new ArrayList<>(userService.getUser());
    }

//    @GetMapping("/test")
//    public String test(){
//        return ("<h1> Succesful test </h1>");
//    }

}
