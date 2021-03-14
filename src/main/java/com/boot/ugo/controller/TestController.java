package com.boot.ugo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author gnl
 */

@RestController
@RequestMapping("/ugo/test")
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "TestController, hello";
    }

}
