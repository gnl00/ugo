package com.boot.ugo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.ugo.entity.Customer;

/**
 * CustomerService
 *
 * @author gnl
 */

public interface CustomerService extends IService<Customer> {

    /**
     * 顾客登录
     *
     * @author gnl
     * @param name
     * @param password
     * @return java.lang.String
     */
    String login(String name, String password);

    /**
     * register
     *
     * @author gnl
     * @param nickName
     * @param password
     * @param email
     * @return int
     */
    int register(String nickName, String password, String email);
}
