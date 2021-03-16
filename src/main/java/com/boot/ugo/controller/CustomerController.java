package com.boot.ugo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.boot.ugo.entity.Customer;
import com.boot.ugo.entity.CustomerAddress;
import com.boot.ugo.entity.vo.CustomerAddressVo;
import com.boot.ugo.service.CustomerAddressService;
import com.boot.ugo.service.CustomerService;
import com.boot.ugo.utils.JwtTokenUtils;
import com.boot.ugo.vo.Result;
import com.boot.ugo.vo.ReturnResult;
import com.boot.ugo.vo.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
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

    @Autowired
    CustomerAddressService addressService;

    @GetMapping("/hello")
    public String hello(){
        return "CustomerController, hello...";
    }

    @PostMapping("/register")
    public Result register(@RequestBody Map<String, Object> registerMap) {
        // 200 405

        System.out.println(registerMap);

        String nickName = (String) registerMap.get("username");
        String password = (String) registerMap.get("password");
        String email = (String) registerMap.get("email");

        // log.info(nickName);
        // log.info(password);

        int result = customerService.register(nickName, password, email);

        if ( result != 1 ) {
            return ReturnResult.fail(StatusCode.SERVICE_UNAVAILABLE, "操作失败！");
        }

        return ReturnResult.ok();
    }

    @PostMapping("/login")
    public Result login(@RequestBody Map<String, Object> map){
        // log.info(map.toString());

        String name = (String) map.get("username");
        String password = (String) map.get("password");

        // log.info(name);
        // log.info(password);

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
    public Result logout(HttpServletResponse response) {
        // 将token设置过期
        log.info("logout now...");

        return ReturnResult.ok();
    }

    public Customer getUserFromToken(HttpServletRequest request) {

        String token = request.getHeader(JwtTokenUtils.JWT_HEADER).replace(JwtTokenUtils.JWT_PREFIX, "");

        String username = JwtTokenUtils.getTokenSubject(token);

        QueryWrapper<Customer> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);

        Customer customer = customerService.getOne(wrapper);

        if (customer != null ) {
            return customer;
        } else {
            return  null;
        }
    }

}
