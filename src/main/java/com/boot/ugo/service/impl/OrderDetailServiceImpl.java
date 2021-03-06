package com.boot.ugo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.ugo.entity.OrderDetail;
import com.boot.ugo.mapper.OrderDetailMapper;
import com.boot.ugo.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
 * OrderDetailServiceImpl
 *
 * @author gnl
 */

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
