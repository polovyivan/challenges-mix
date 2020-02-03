package com.ivan.polovyi.challenges.springboot.jwt.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloJWTController {

    @GetMapping("/jwt")
    public String helloJwt() {
        return "Hello from JWT";
    }

}
