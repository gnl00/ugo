package com.boot.ugo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.boot.ugo.entity.Category;
import com.boot.ugo.entity.vo.CategoryVo;
import com.boot.ugo.mapper.CategoryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * CategoryTest
 *
 * @author gnl
 */

@SpringBootTest
public class CategoryTest {

    @Resource
    CategoryMapper categoryMapper;

    @Test
    public void test1() {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.eq("level", 0);
        List<Category> top = categoryMapper.selectList(wrapper);
        top.forEach(System.out::println);
    }

    @Test
    public void test2() {
        List<CategoryVo> allCategories = categoryMapper.getAllCategories();
        allCategories.forEach(System.out::println);
    }
}
