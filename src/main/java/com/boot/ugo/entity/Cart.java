package com.boot.ugo.entity;

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
     * 商品总价
     */
    private BigDecimal total;

}
