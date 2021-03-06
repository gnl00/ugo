package com.boot.ugo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.ugo.entity.GoodsCategory;
import com.boot.ugo.mapper.GoodsCategoryMapper;
import com.boot.ugo.service.GoodsCategoryService;
import org.springframework.stereotype.Service;

/**
 * GoodsCategoryServiceImpl
 *
 * @author gnl
 */

@Service
public class GoodsCategoryServiceImpl extends ServiceImpl<GoodsCategoryMapper, GoodsCategory> implements GoodsCategoryService {
}
