package com.boot.ugo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.ugo.entity.Goods;
import com.boot.ugo.entity.vo.CategoryGoodsVo;
import com.boot.ugo.entity.vo.HomeGoodsVo;
import com.boot.ugo.vo.PageResult;
import org.apache.ibatis.javassist.NotFoundException;

import java.util.List;

/**
 * GoodsService
 *
 * @author gnl
 */

public interface GoodsService extends IService<Goods> {

    /**
     * getRecommendGoods 获取首页推荐数据
     * @throws NotFoundException
     * @author gnl
     * @return java.util.List<com.boot.ugo.entity.Goods>
     */
    List<HomeGoodsVo> getRecommendGoods() throws NotFoundException;

    /**
     * getHomeGoods 分页获取首页选项卡数据
     *
     * @author gnl
     * @param type
     * @param page
     * @throws NotFoundException
     * @return com.boot.ugo.vo.PageResult;
     */
    PageResult getHomeGoods(String type, long page) throws NotFoundException;

    /**
     * getGoodsBySort 根据排序获取商品
     *
     * @author gnl
     * @param categoryId
     * @param sort
     * @return com.boot.ugo.vo.PageResult
     */
    List<CategoryGoodsVo> getGoodsBySort(Integer categoryId,String sort);

}
