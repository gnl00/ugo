package com.boot.ugo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.ugo.entity.Goods;

import java.util.List;

/**
 * GoodsMapper
 *
 * @author gnl
 */

public interface GoodsMapper extends BaseMapper<Goods> {

    /**
     * 获取首页推荐数据
     * 采用MySQL随机查询语句
     *
     * @author gnl
     * @return java.util.List<com.boot.ugo.entity.Goods>
     */
    List<Goods> getRecommendGoods();


    /**
     * 分页获取首页选项卡数据
     *
     * @author gnl
     * @return java.util.List<com.boot.ugo.entity.Goods>
     */
    List<Goods> getTabGoods();

}
