package com.boot.ugo.controller;

import com.boot.ugo.vo.Result;
import com.boot.ugo.vo.ReturnResult;
import com.boot.ugo.vo.StatusCode;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TestController
 *
 * @author gnl
 */

@RestController
@RequestMapping("/ugo/test")
public class TestController {

    @GetMapping("/hello")
    public Result hello(){
        int i = 10/0;
        return ReturnResult.fail(StatusCode.UNAUTHORIZED, "我就是不放行");
    }

}
