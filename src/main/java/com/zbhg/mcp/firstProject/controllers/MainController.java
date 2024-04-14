package com.zbhg.mcp.firstProject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping(path = "/mainHeading")
    public @ResponseBody String mainHeading() {
        return "POS SYSTEM";
    }

//    @GetMapping(path = "/api/hello")
//    public String sayHello(@RequestParam(defaultValue = "World") String name) {
//        return "Hello, " + name + "!";
//    }



}
