package com.boot.ugo.entity.vo;

import com.boot.ugo.entity.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * GoodsVo 封装goods和goodsPicture
 *
 * @author gnl
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GoodsVo {

    private Goods goods;
    private List<String> picture;

    /**
     * parentId 父级分类id 用于查找相似商品
     */
    private Integer parentId;

}
