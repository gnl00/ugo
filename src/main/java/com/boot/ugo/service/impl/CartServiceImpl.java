package com.boot.ugo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.ugo.entity.Cart;
import com.boot.ugo.mapper.CartMapper;
import com.boot.ugo.service.CartService;
import org.springframework.stereotype.Service;

/**
 * CartServiceImpl
 *
 * @author gnl
 */

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {
}
