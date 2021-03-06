package com.boot.ugo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.ugo.entity.Goods;
import com.boot.ugo.mapper.GoodsMapper;
import com.boot.ugo.service.GoodsService;
import org.springframework.stereotype.Service;

/**
 * GoodsServiceImpl
 *
 * @author gnl
 */

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
}
