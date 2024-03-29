package com.boot.ugo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

/**
 * Goods 商品实体类
 *
 * @author gnl
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Goods {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;

    /**
     * 涉及到金额运算需要用BigDecimal类型
     */
    private BigDecimal price;

    /**
     * 商品库存量
     */
    private Integer amount;

    /**
     * 商品详情描述
     */
    private String description;

    /**
     * 商品收藏数
     */
    private Integer collect;

    /**
     * 商品状态
     * 1. up 上架，可被搜索，可下单
     * 2. down 下架，可被搜索，无法下单
     * 3. disable 删除，不可被搜索
     */
    private String status;

}
