package com.boot.ugo.security.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.boot.ugo.entity.Customer;
import com.boot.ugo.mapper.CustomerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserDetailsServiceImpl SpringSecurity用户登录检查类
 *
 * @author gnl
 */

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    CustomerMapper customerMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info(username);

        if (StringUtils.hasLength(username)) {

            // 加载用户基础信息
            QueryWrapper<Customer> wrapper = new QueryWrapper<>();
            wrapper.eq("nick_name", username);
            Customer customer = customerMapper.selectOne(wrapper);

            if (customer != null){

                // 获得用户角色
                // 通过用户角色列表加载用户的资源列表
                // String role = user.getRole();
                // ...

                List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER", "user:view");

                return new org.springframework.security.core.userdetails.User(username, passwordEncoder.encode(customer.getPassword()), authorities);

            }
            throw new UsernameNotFoundException("用户不存在");
        }
        throw new UsernameNotFoundException("用户名为空");
    }
}
