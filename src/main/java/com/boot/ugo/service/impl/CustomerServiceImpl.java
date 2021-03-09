package com.boot.ugo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.ugo.entity.Customer;
import com.boot.ugo.mapper.CustomerMapper;
import com.boot.ugo.security.impl.UserDetailsServiceImpl;
import com.boot.ugo.service.CustomerService;
import com.boot.ugo.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * CustomerServiceImpl
 *
 * @author gnl
 */

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public String login(String name, String password) throws BadCredentialsException {

        UserDetails userDetails = userDetailsService.loadUserByUsername(name);

        if (userDetails != null){
            boolean matches = passwordEncoder.matches(password, userDetails.getPassword());

            if (matches) {
                return JwtTokenUtils.JWT_PREFIX + JwtTokenUtils.createToken(userDetails);
            }

            throw new BadCredentialsException("用户名或密码错误");

        }

        throw new BadCredentialsException("用户名或密码错误");
    }

}
