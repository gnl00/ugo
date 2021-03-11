package com.boot.ugo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * GoodsCategory 商品对应分类实体类
 *
 * @author gnl
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GoodsCategory {

    private Integer id;
    private Integer goodsId;

    /**
     * 一级分类id
     */
    private Integer categoryOne;

    /**
     * 二级分类Id
     */
    private Integer categoryTwo;


    /**
     * 三级分类Id
     */
    private Integer categoryThree;

}
