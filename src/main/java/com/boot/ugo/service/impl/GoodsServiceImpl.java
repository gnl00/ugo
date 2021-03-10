package com.boot.ugo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.ugo.entity.Goods;
import com.boot.ugo.entity.GoodsPicture;
import com.boot.ugo.entity.vo.HomeGoodsVo;
import com.boot.ugo.mapper.GoodsMapper;
import com.boot.ugo.mapper.GoodsPictureMapper;
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
    public List<HomeGoodsVo> getRecommendGoods() throws NotFoundException {

        List<HomeGoodsVo> recommendGoods = goodsMapper.getRecommendGoods();

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

                minId = 30;
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

                minId = 150;
                maxId = 300;

                break;
            default:

                /**
                 * 默认返回 【热门畅销】
                 *
                 */

                log.info("getHomeGoods ===> default");

                minId = 70;
                maxId = 150;

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

        List<HomeGoodsVo> homeGoodsVos = new ArrayList<>();

        for (Goods good : goods) {

            QueryWrapper<GoodsPicture> pictureWrapper  = new QueryWrapper<>();
            pictureWrapper.eq("goods_id", good.getId());
            List<GoodsPicture> goodsPictures = goodsPictureService.list(pictureWrapper);
            List<String> pictures = goodsPictures.stream().map(GoodsPicture::getPicture).collect(Collectors.toList());

            homeGoodsVos.add(new HomeGoodsVo(good, pictures));
        }

        if (CollectionUtils.isEmpty(homeGoodsVos)){
            throw new NotFoundException("获取选项卡商品信息失败");
        }

        return new PageResult(goodsPage.getCurrent(), homeGoodsVos);
    }
}
