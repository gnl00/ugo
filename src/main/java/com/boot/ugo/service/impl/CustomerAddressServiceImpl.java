package com.boot.ugo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.ugo.entity.CustomerAddress;
import com.boot.ugo.mapper.CustomerAddressMapper;
import com.boot.ugo.service.CustomerAddressService;
import org.springframework.stereotype.Service;

/**
 * CustomerAddressServiceImpl
 *
 * @author gnl
 */

@Service
public class CustomerAddressServiceImpl extends ServiceImpl<CustomerAddressMapper, CustomerAddress> implements CustomerAddressService {
}
