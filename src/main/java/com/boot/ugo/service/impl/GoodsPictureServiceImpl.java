package com.boot.ugo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.ugo.entity.GoodsPicture;
import com.boot.ugo.mapper.GoodsPictureMapper;
import com.boot.ugo.service.GoodsPictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * GoodsPictureServiceImpl
 *
 * @author gnl
 */

@Service
public class GoodsPictureServiceImpl extends ServiceImpl<GoodsPictureMapper, GoodsPicture> implements GoodsPictureService {

    @Resource
    GoodsPictureMapper goodsPictureMapper;

    @Override
    public GoodsPicture getOnePictureByGoodsId(Integer goodsId) {

        QueryWrapper<GoodsPicture> wrapper = new QueryWrapper<>();
        wrapper.eq("goods_id", goodsId).last("limit 1");
        GoodsPicture picture = goodsPictureMapper.selectOne(wrapper);

        return picture;
    }
}
