package com.boot.ugo.controller;

import com.boot.ugo.entity.vo.CategoryVo;
import com.boot.ugo.service.CategoryService;
import com.boot.ugo.vo.Result;
import com.boot.ugo.vo.ReturnResult;
import com.boot.ugo.vo.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CategoryController 商品分类Controller
 *
 * @author gnl
 */

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/ugo/cat")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    /**
     * 获取所有分类信息
     *
     * @author gnl
     * @return com.boot.ugo.vo.Result
     */
    @GetMapping("/all")
    public Result getAllCategories() {

        List<CategoryVo> allCategories = categoryService.getAllCategories();

        if (CollectionUtils.isEmpty(allCategories)){
            return ReturnResult.fail(StatusCode.NOTFOUND, "获取分类信息失败");
        }

        return ReturnResult.ok(allCategories);
    }

}
