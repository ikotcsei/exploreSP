package com.explorespring.exploreSP.controllers;


import com.explorespring.exploreSP.model.Authority;
import com.explorespring.exploreSP.jsonmodels.Greeting;
import com.explorespring.exploreSP.model.User;
import com.explorespring.exploreSP.services.AuthorityServiceImpl;
import com.explorespring.exploreSP.services.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
/*ACCESS HTTP HEADERS : https://www.baeldung.com/spring-rest-http-headers

    @Crossorigins : https://spring.io/guides/gs/rest-service-cors/ (overwrite local, global )

    @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
* */


/*
//@RequestMapping - produce, consume
    https://www.baeldung.com/spring-requestmapping
    https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestMapping.html#produces--

    @RequestMapping(method = RequestMethod.GET) == @GetMapping
*/


/* @Responsebody  - object returned automatically serialized into JSON
and @Requestbody - inc object in JSON, automatically deserializes the JSON into a Java type
    https://www.baeldung.com/spring-request-response-body
*
*
*/

/* @Controller : specialized @Component, allows implementation classes to be autodetected through the classpath scanning.
   @Restcontroller = @Controller + @Responsebody
*
*
* */


//for react axios from https 8443 to http 3000
//@CrossOrigin(origins = "http://localhost:3000")

//@RequestMapping marks request handler methods inside @Controller classes, sets relative url mapping to root
//first match will be used
@RequestMapping("/")
@Controller
public class HomeController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    UserServiceImpl userServiceImpl;
    AuthorityServiceImpl authorityServiceImpl;

    //constructors r @Autowired
    public HomeController(UserServiceImpl userService, AuthorityServiceImpl authorityService) {
        this.authorityServiceImpl = authorityService;
        this.userServiceImpl = userService;
    }




    @GetMapping("/")
    public String home(){
        return "redirect:/user"; // same as return "redirect:user"
    }




    //REST service
    @ResponseBody
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


    @GetMapping("/user")
    public String user(Model model){
        model.addAttribute("users", userServiceImpl.getUser());
        return "/user";     //same as return "user"
    }

    @GetMapping("/admin")
    public String admin(){
        return "/admin";
    }

    @ResponseBody // raw data response
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/userapi")
    public TreeSet getAllUsers(){
//        return new ArrayList<>(userService.getUser());
        //same result as returning an arraylist
        return (TreeSet) userServiceImpl.getUser();
    }

    @ResponseBody
    @PostMapping("/userapi")
    public void addUser(@RequestBody User user){
        userServiceImpl.saveUser(user);
    }

    @ResponseBody // raw data response
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/authapi")
    public List<Authority> getAuthorities(){
        return new ArrayList<>(authorityServiceImpl.getAuthorities());
    }

    @RequestMapping(value = "/testget", method = RequestMethod.GET)
    @ResponseBody
    public String getFoosBySimplePath() {
        return "Get some Foos";
    }

    @RequestMapping(value = "/testpost", method = RequestMethod.POST)
    @ResponseBody
    public String postFoos() {
        return "Post some Foos";
    }

    //https://localhost:8443/testheader?key=val
    @RequestMapping(value = "/testheader", headers = "key=val", method = RequestMethod.GET)
    @ResponseBody
    public String getFoosWithHeader() {
        return "Get some Foos with Header";
    }

    //mapping request based on ACCEPT,PRODUCE,CONSUME

    @RequestMapping(
            value = "/testheaderold",
            method = RequestMethod.GET,
            headers = "Accept=application/json")    //accept
    @ResponseBody
    public String getFoosAsJsonFromBrowser() {
        return "Get some Foos with Header Old";
    }


    @RequestMapping(
            value = "/testheadernew",
            method = RequestMethod.GET,
            produces = { "application/json", "application/xml" }
    )
    @ResponseBody
    public String getFoosAsJsonFromREST() {
        return "Get some Foos with Header New";
    }




    //pathvariable pl : https://localhost:8443/testpathvar/1
    @RequestMapping(value = "/testpathvar/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getFoosBySimplePathWithPathVariable(
            @PathVariable("id") long id) {
        return "Get a specific Foo with id=" + id;
    }

    //multipl pathvariables
    @RequestMapping(value = "/test/{fooid}/test/{barid}", method = RequestMethod.GET)
    @ResponseBody
    public String getFoosBySimplePathWithPathVariables
            (@PathVariable long fooid, @PathVariable long barid) {
        return "Get a specific Bar with id=" + barid +
                " from a Foo with id=" + fooid;
    }

    //pathvar with regular expression
    @RequestMapping(value = "/testregular/{numericId:[\\d]+}", method = RequestMethod.GET)
    @ResponseBody
    public String getBarsBySimplePathWithPathVariable(
            @PathVariable long numericId) {
        return "Get a specific Bar with id=" + numericId;
    }

    //this wont run, above reggular expression will be mapped first
    @RequestMapping(value = "/testregular/{numericId:123}", method = RequestMethod.GET)
    @ResponseBody
    public String getBarsBySimplePathWithPathVariablea(@PathVariable long numericId) {
        return "this is never called : Get a specific Bar with id="+ numericId;
    }

    //more requestmapping with parameters
    @RequestMapping(
            value = "/moreparams",
            params = { "id", "second" },
            method = RequestMethod.GET)
    @ResponseBody
    public String getBarBySimplePathWithExplicitRequestParams(
            @RequestParam("id") long id) {
        return "Narrow Get a specific Bar with id=" + id;
    }

    //multiple path to same controller
    @RequestMapping(
            value = { "/pathone", "/pathtwo" },
            method = RequestMethod.GET)
    @ResponseBody
    public String getFoosOrBarsByPath() {
        return "Advanced - Get some Foos or Bars";
    }

    //fallback for all requests
    @RequestMapping(
            value = "*",
            method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public String allFallback() {
        return "Fallback for All Requests";
    }

}
