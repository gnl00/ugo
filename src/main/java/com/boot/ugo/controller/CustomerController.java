package com.boot.ugo.controller;

import com.boot.ugo.service.CustomerService;
import com.boot.ugo.utils.JwtTokenUtils;
import com.boot.ugo.vo.Result;
import com.boot.ugo.vo.ReturnResult;
import com.boot.ugo.vo.StatusCode;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * CustomerController
 *
 * @author gnl
 */

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/ugo/cus")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/hello")
    public String hello(){
        return "CustomerController, hello...";
    }

    @PostMapping("/register")
    public Result register(@RequestBody Map<String, Object> registerMap) {
        // 200 405

        System.out.println(registerMap);

        return ReturnResult.ok(registerMap);
    }

    @PostMapping("/login")
    public Result login(@RequestBody Map<String, Object> map){
        log.info(map.toString());

        String name = (String) map.get("username");
        String password = (String) map.get("password");

        log.info(name);
        log.info(password);

        try {
            String token = customerService.login(name, password);

            if (StringUtils.hasLength(token)){
                return ReturnResult.ok(token);
            }

            return ReturnResult.fail(StatusCode.UNAUTHORIZED, "登录失败");

        } catch (Exception exception) {
            return ReturnResult.fail(StatusCode.UNAUTHORIZED, exception.getMessage());
        }
    }

    @PostMapping("/logout")
    public Result logout(HttpServletRequest request) {

        String token = request.getHeader(JwtTokenUtils.JWT_HEADER).replace(JwtTokenUtils.JWT_PREFIX, "");

        // 将token设置过期
        log.info("logout now...");


        return ReturnResult.ok(token);
    }

}
