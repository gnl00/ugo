package com.boot.ugo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.ugo.entity.Category;
import com.boot.ugo.entity.vo.CategoryVo;

import java.util.List;

/**
 * CategoryMapper
 *
 * @author gnl
 */

public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * getAllCategories 获取所有分类信息
     *
     * @author gnl
     * @return java.util.List<com.boot.ugo.entity.vo.CategoryVo>
     */
    List<CategoryVo> getAllCategories();

}
