package com.zbhg.mcp.firstProject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping(path = "/")
    public @ResponseBody String sayHello() {
        System.out.println("Starting");
        return "Hello World";
    }

}
