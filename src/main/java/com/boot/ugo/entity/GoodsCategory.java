package com.boot.ugo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * GoodsCategory 商品分类实体类
 *
 * @author gnl
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GoodsCategory {

    private Integer id;
    private String name;

}
