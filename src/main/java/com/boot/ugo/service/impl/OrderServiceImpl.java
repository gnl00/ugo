package com.boot.ugo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.ugo.entity.Order;
import com.boot.ugo.mapper.OrderMapper;
import com.boot.ugo.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * OrderServiceImpl
 *
 * @author gnl
 */

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}
