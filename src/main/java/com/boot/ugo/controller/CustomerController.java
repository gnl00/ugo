package com.boot.ugo.controller;

import com.boot.ugo.service.CustomerService;
import com.boot.ugo.util.JwtTokenUtils;
import com.boot.ugo.vo.Result;
import com.boot.ugo.vo.ReturnResult;
import com.boot.ugo.vo.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * CustomerController
 *
 * @author gnl
 */

@Slf4j
@RestController
@RequestMapping("/ugo/cus")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/hello")
    public String hello(){
        return "CustomerController, hello...";
    }

    @PostMapping("/login")
    public Result login(@RequestBody Map<String, Object> map, HttpServletResponse response){
        log.info(map.toString());

        String name = (String) map.get("name");
        String password = (String) map.get("password");

        try {
            String token = customerService.login(name, password);

            if (StringUtils.hasLength(token)){
                response.setHeader(JwtTokenUtils.JWT_HEADER, token);
                return ReturnResult.ok();
            }

            return ReturnResult.fail(StatusCode.UNAUTHORIZED, "登录失败");

        } catch (Exception exception) {
            return ReturnResult.fail(StatusCode.UNAUTHORIZED, exception.getMessage());
        }
    }

}
