package com.boot.ugo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.ugo.entity.Customer;
import com.boot.ugo.mapper.CustomerMapper;
import com.boot.ugo.security.impl.UserDetailsServiceImpl;
import com.boot.ugo.service.CustomerService;
import com.boot.ugo.util.JwtTokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * CustomerServiceImpl
 *
 * @author gnl
 */

@Slf4j
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    static final String SALT = "asfnGEAw32$#@%123TEQse";

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Resource
    CustomerMapper customerMapper;

    @Override
    public String login(String name, String rawPassword) throws BadCredentialsException {
        UserDetails userDetails = userDetailsService.loadUserByUsername(name);
        if (userDetails != null){
            boolean matches = BCrypt.checkpw(rawPassword, userDetails.getPassword());
            if (matches) {
                return JwtTokenUtils.createToken(userDetails);
            }
            throw new BadCredentialsException("用户名或密码错误");
        }
        throw new BadCredentialsException("用户名或密码错误");
    }

    @Override
    public int register(String username, String password, String email) {

        String hashpw = BCrypt.hashpw(password, BCrypt.gensalt(10));
        Customer customer = new Customer(username, hashpw, email);

        return customerMapper.insert(customer);
    }

}
