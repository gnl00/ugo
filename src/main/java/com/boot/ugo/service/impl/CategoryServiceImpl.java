package com.boot.ugo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.ugo.entity.Category;
import com.boot.ugo.entity.vo.CategoryVo;
import com.boot.ugo.mapper.CategoryMapper;
import com.boot.ugo.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * CategoryServiceImpl
 *
 * @author gnl
 */

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Resource
    CategoryMapper categoryMapper;

    @Override
    public List<CategoryVo> getAllCategories() {
        return categoryMapper.getAllCategories();
    }
}
