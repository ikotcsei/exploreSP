package com.explorespring.exploreSP.controllers;


import com.explorespring.exploreSP.repositories.UserRepository;
import com.explorespring.exploreSP.services.UserService;
import com.explorespring.exploreSP.services.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

//    UserRepository userRepository;
    UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    //constructors r @Autowired


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

//    @GetMapping("/test")
//    public String test(){
//        return ("<h1> Succesful test </h1>");
//    }

}
