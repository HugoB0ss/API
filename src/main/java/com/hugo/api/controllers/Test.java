package com.hugo.api.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class Test {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}