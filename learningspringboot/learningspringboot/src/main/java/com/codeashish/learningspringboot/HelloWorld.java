package com.codeashish.learningspringboot;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @org.springframework.web.bind.annotation.GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

}
