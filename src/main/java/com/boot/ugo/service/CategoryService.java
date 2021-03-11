package com.boot.ugo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.ugo.entity.Category;
import com.boot.ugo.entity.vo.CategoryVo;

import java.util.List;

/**
 * CategoryService
 *
 * @author gnl
 */

public interface CategoryService extends IService<Category> {

    /**
     * getAllCategories 获取所有分类信息
     *
     * @author gnl
     * @return java.util.List<com.boot.ugo.entity.vo.CategoryVo>
     */
    List<CategoryVo> getAllCategories();

}
