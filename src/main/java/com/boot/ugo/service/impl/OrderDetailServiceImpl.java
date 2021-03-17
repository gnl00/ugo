package com.boot.ugo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.ugo.entity.OrderDetail;
import com.boot.ugo.mapper.OrderDetailMapper;
import com.boot.ugo.service.OrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * OrderDetailServiceImpl
 *
 * @author gnl
 */

@Slf4j
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

    @Resource
    OrderDetailMapper detailMapper;

    @Override
    public int saveAndReturnId(OrderDetail detail) {
        return detailMapper.insertAndReturnId(detail);
    }
}
