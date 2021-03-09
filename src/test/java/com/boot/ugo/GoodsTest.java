package com.boot.ugo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boot.ugo.entity.Goods;
import com.boot.ugo.mapper.GoodsMapper;
import com.boot.ugo.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * GoodsTest 商品功能测试类
 *
 * @author gnl
 */

@SpringBootTest
public class GoodsTest {

    @Resource
    GoodsMapper goodsMapper;

    @Autowired
    GoodsService goodsService;

    @Test
    public void getRecommendGoods() {
        List<Goods> goods = goodsService.getRecommendGoods();
        goods.forEach(System.out::println);
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
        wrapper.select("id").le("id", 100);
        Page<Goods> goodsPage = goodsMapper.selectPage(page, wrapper);
        List<Goods> goods = goodsPage.getRecords();
        goods.forEach(System.out::println);
    }

}
