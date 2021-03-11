package com.boot.ugo.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * GoodsCategoryVo 商品分类封装类
 *
 * @author gnl
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryVo {

    private Integer id;
    private String category;
    private List<CategoryVo> children;

}
