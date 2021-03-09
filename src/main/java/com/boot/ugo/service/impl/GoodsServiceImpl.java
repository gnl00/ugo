package com.boot.ugo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.ugo.entity.Goods;
import com.boot.ugo.mapper.GoodsMapper;
import com.boot.ugo.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * GoodsServiceImpl
 *
 * @author gnl
 */

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Resource
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> getRecommendGoods() {
        return goodsMapper.getRecommendGoods();
    }

    @Override
    public List<Goods> getTabGoods() {

        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        wrapper.select("");
        List<Goods> goods = goodsMapper.selectList(wrapper);

        return goods;
    }
}
