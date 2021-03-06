package com.boot.ugo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * OrderDetail 订单明细实体类
 *
 * @author gnl
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

    private Integer id;

    /**
     * 商品Id
     */
    private Integer goodsId;

    /**
     * 商品数量
     */
    private Integer quantity;

    /**
     * 购买总额
     */
    private BigDecimal total;

}
