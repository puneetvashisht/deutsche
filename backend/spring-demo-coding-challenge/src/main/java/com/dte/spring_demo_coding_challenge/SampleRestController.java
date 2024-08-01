package com.dte.spring_demo_coding_challenge;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

class SampleController {


    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, Spring Boot!";
    }
    
    //get mapping welcome withPathVariable
    @GetMapping("/welcome/{name}")
    public String welcome(@PathVariable String name) {
        return "Welcome, " + name + "!";
    }
    

    
}
