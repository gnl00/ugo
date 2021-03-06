package com.boot.ugo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author gnl
 * @date 2021-03-06 14:41
 */

@RestController
@RequestMapping("/ugo/cus")
public class CustomerController {

    @GetMapping("/hello")
    public String hello(){
        return "CustomerController, hello...";
    }

}
