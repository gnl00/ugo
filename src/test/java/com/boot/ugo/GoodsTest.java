package com.boot.ugo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boot.ugo.entity.Goods;
import com.boot.ugo.entity.GoodsPicture;
import com.boot.ugo.entity.vo.HomeGoodsVo;
import com.boot.ugo.mapper.GoodsMapper;
import com.boot.ugo.mapper.GoodsPictureMapper;
import com.boot.ugo.service.GoodsService;
import com.boot.ugo.vo.PageResult;
import org.apache.ibatis.javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * GoodsTest 商品功能测试类
 *
 * @author gnl
 */

@SpringBootTest
public class GoodsTest {

    @Resource
    GoodsMapper goodsMapper;

    @Resource
    GoodsPictureMapper pictureMapper;

    @Autowired
    GoodsService goodsService;

    @Test
    public void testPictureMapper() {
        QueryWrapper<GoodsPicture> wrapper = new QueryWrapper<>();
        wrapper.eq("goods_id", 1).last("limit 1");
        GoodsPicture picture = pictureMapper.selectOne(wrapper);
        System.out.println(picture);
    }

    @Test
    public void getRecommendGoods() throws NotFoundException {
        List<HomeGoodsVo> goodsVos = goodsService.getRecommendGoods();
    }


    @Test
    public void test1() {
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        wrapper.select("id, name, description,price, amount, photo, category_id, status");
        List<Goods> goods = goodsMapper.selectList(wrapper);
        goods.forEach(System.out::println);
    }
    
    @Test
    public void testPage() {
        Page<Goods> page = new Page<>();
        page.setCurrent(2l);
        page.setSize(16l);
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        // id 300之内的为热销
        wrapper.select("id").ge("id", 1).le("id", 300);
        Page<Goods> goodsPage = goodsMapper.selectPage(page, wrapper);
        List<Goods> goods = goodsPage.getRecords();
        goods.forEach(System.out::println);
    }

    @Test
    public void testGetHomeGoods() throws NotFoundException {

        PageResult result = goodsService.getHomeGoods("hot", 2);
        System.out.println(result);

    }

}
