package com.boot.ugo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boot.ugo.entity.Goods;
import com.boot.ugo.entity.vo.HomeGoodsVo;

import java.util.List;

/**
 * GoodsMapper
 *
 * @author gnl
 */

public interface GoodsMapper extends BaseMapper<Goods> {

    /**
     * getRecommendGoods 获取首页推荐数据
     *
     * @author gnl
     * @return java.util.List<com.boot.ugo.entity.Goods>
     */
    List<HomeGoodsVo> getRecommendGoods();

}
