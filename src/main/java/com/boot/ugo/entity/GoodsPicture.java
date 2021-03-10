package com.boot.ugo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * GoodsPicture 商品照片实体类
 *
 * @author gnl
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GoodsPicture {

    /**
     * 照片id
     */
    private Integer id;

    /**
     * 所属商品id
     */
    private Integer goodsId;

    /**
     * 照片路径
     */
    private String picture;

}
