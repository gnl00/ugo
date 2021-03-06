package com.boot.ugo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.ugo.entity.Customer;
import com.boot.ugo.mapper.CustomerMapper;
import com.boot.ugo.service.CustomerService;
import org.springframework.stereotype.Service;

/**
 * CustomerServiceImpl
 *
 * @author gnl
 */

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
}
