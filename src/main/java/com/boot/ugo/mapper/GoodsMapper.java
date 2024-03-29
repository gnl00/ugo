package com.boot.ugo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boot.ugo.entity.Goods;
import com.boot.ugo.entity.vo.CategoryGoodsVo;
import com.boot.ugo.entity.vo.GoodsVo;

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
    List<GoodsVo> getRecommendGoods();

    /**
     * getGoodsBySort 根据分类排序获取商品
     *
     * @author gnl
     * @param categoryId
     * @param sort
     * @return com.boot.ugo.vo.PageResult
     */
    List<CategoryGoodsVo> getGoodsBySort(Integer categoryId, String sort);

    /**
     * getGoodsById
     *
     * @author gnl
     * @param goodsId
     * @return com.boot.ugo.entity.vo.GoodsVo
     */
    GoodsVo getGoodsById(Integer goodsId);

    /**
     * getGoodsByParentId 根据二级分类id获取商品
     *
     * @author gnl
     * @param parentId
     * @return java.util.List<com.boot.ugo.entity.vo.GoodsVo>
     */
    List<GoodsVo> getGoodsByParentId(Integer parentId);

    /**
     * getGoodsByKeyword
     *
     * @author gnl
     * @param keyword
     * @param order
     * @return java.util.List<com.boot.ugo.entity.vo.GoodsVo>
     */
    List<GoodsVo> getGoodsByKeyword(String keyword, String order);

    /**
     * getHomeGoodsByPage 自定义分页
     * @param page 只需要将page作为参数传入即可
     * @param minId
     * @param maxId
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.boot.ugo.entity.vo.GoodsVo>
     * @author gnl
     */
    IPage<GoodsVo> getHomeGoodsByPage(Page<?> page, Integer minId, Integer maxId);

}
