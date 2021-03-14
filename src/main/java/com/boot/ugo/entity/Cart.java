package com.boot.ugo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * Cart 购物车实体类
 *
 * @author gnl
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 购物车所属用户Id
     */
    private Integer customerId;

    /**
     * 购物车所包含商品Id
     */
    private Integer goodsId;

    /**
     * 商品数量
     */
    private Integer quantity;

    /**
     * 商品单价
     */
    private BigDecimal price;

    /**
     * 商品总价
     */
    private BigDecimal total;

}
