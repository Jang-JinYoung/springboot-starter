package com.example.springbootstarter.controller;

import com.example.springbootstarter.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    Service service;


    @GetMapping("/hello")
    public String Hello() {
        return "hello";
    }

}
