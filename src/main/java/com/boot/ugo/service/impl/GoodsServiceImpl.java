package com.boot.ugo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.enums.SqlLike;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.ugo.entity.Goods;
import com.boot.ugo.entity.GoodsPicture;
import com.boot.ugo.entity.vo.CategoryGoodsVo;
import com.boot.ugo.entity.vo.GoodsVo;
import com.boot.ugo.mapper.GoodsMapper;
import com.boot.ugo.service.GoodsPictureService;
import com.boot.ugo.service.GoodsService;
import com.boot.ugo.vo.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * GoodsServiceImpl
 *
 * @author gnl
 */

@Slf4j
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Resource
    GoodsMapper goodsMapper;

    @Autowired
    GoodsPictureService goodsPictureService;

    @Override
    public List<GoodsVo> getRecommendGoods() throws NotFoundException {

        List<GoodsVo> recommendGoods = goodsMapper.getRecommendGoods();

        if (CollectionUtils.isEmpty(recommendGoods)){
            throw new NotFoundException("获取推荐商品信息失败");
        }

        return recommendGoods;
    }

    @Override
    public PageResult getHomeGoods(String type, long page) throws NotFoundException {

        // 商品id区间
        int minId, maxId;
        // 热门畅销
        final String HOT = "hot";
        // 近日上新
        final String NEW = "new";
        // 历史精选
        final String HISTORY = "history";

        switch (type) {
            case HOT:

                /**
                 * 获取【热门畅销】 返回id区间 1-70 商品
                 *
                 */

                log.info("getHomeGoods ===> HOT");

                minId = 20;
                maxId = 70;

                break;
            case NEW:

                /**
                 * 获取【近日上新】 返回id区间 70-140 商品
                 *
                 */

                log.info("getHomeGoods ===> NEW");

                minId = 70;
                maxId = 140;

                break;
            case HISTORY:

                /**
                 * 获取【历史精选】 返回id区间 大于 600 商品
                 *
                 */

                log.info("getHomeGoods ===> HISTORY");

                minId = 140;
                maxId = 300;

                break;
            default:

                /**
                 * 默认返回 【热门畅销】
                 *
                 */

                log.info("getHomeGoods ===> default");

                minId = 30;
                maxId = 2000;

        }

        Page<Goods> pageWrapper = new Page<>();
        pageWrapper.setCurrent(page);
        pageWrapper.setSize(16);

        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        wrapper.select("id,name,price,collect")
                .eq("status", "up")
                .ge("id", minId)
                .le("id", maxId);

        Page<Goods> goodsPage = goodsMapper.selectPage(pageWrapper, wrapper);
        List<Goods> goods = goodsPage.getRecords();

        List<GoodsVo> goodsVos = new ArrayList<>();

        for (Goods good : goods) {

            QueryWrapper<GoodsPicture> pictureWrapper  = new QueryWrapper<>();
            pictureWrapper.eq("goods_id", good.getId());
            List<GoodsPicture> goodsPictures = goodsPictureService.list(pictureWrapper);
            List<String> pictures = goodsPictures.stream().map(GoodsPicture::getPicture).collect(Collectors.toList());

            goodsVos.add(new GoodsVo(good, pictures, null));
        }

        if (CollectionUtils.isEmpty(goodsVos)){
            throw new NotFoundException("获取选项卡商品信息失败");
        }

        return new PageResult(goodsPage.getCurrent(), goodsVos);
    }

    @Override
    public List<CategoryGoodsVo> getGoodsBySort(Integer categoryId, String sort) {

        // 综合排序
        final String COMP = "comp";

        // 销量排序 按照收藏数排序
        final String SALES = "sales";

        // 价格排序
        final String PRICE = "price";

        List<CategoryGoodsVo> goods =  null;

        switch (sort) {
            case COMP:
                log.info("获取综合排序");

                goods = goodsMapper.getGoodsBySort(categoryId, "goods_id");

                break;
            case SALES:
                log.info("获取销售排序");

                goods = goodsMapper.getGoodsBySort(categoryId, "collect");

                break;
            case PRICE:
                log.info("获取价格排序");

                goods = goodsMapper.getGoodsBySort(categoryId, "price");

                break;
            default:
                log.info("默认排序");
                goods = goodsMapper.getGoodsBySort(categoryId, "goods_id");
        }

        return goods;
    }

    @Override
    public GoodsVo getGoodsById(Integer goodsId) {
        return goodsMapper.getGoodsById(goodsId);
    }

    @Override
    public List<GoodsVo> getByParentId(Integer parentId) {
        return goodsMapper.getGoodsByParentId(parentId);
    }

    @Override
    public List<GoodsVo> getGoodsByKeyword(String keyword, String order) {

        String orderToMapper = "";

        switch (order) {
            case "default":

                orderToMapper = "goods.id";

                break;
            case "price":

                orderToMapper = "goods.price";

                break;
            case "collect":

                orderToMapper = "goods.collect";

                break;
            default:
                orderToMapper = "goods.id";
        }

        return goodsMapper.getGoodsByKeyword(keyword, orderToMapper);
    }
}
