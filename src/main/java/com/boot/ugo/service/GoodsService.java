package com.boot.ugo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.ugo.entity.Goods;

import java.util.List;

/**
 * GoodsService
 *
 * @author gnl
 */

public interface GoodsService extends IService<Goods> {

    /**
     * 获取首页推荐数据
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
