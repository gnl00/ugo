package com.boot.ugo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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

    @TableId(value = "id", type = IdType.AUTO)
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
     * 商品单价
     */
    private BigDecimal price;

    /**
     * 购买总额
     */
    private BigDecimal total;

    public OrderDetail(Integer goodsId, Integer quantity, BigDecimal price, BigDecimal total) {
        this.goodsId = goodsId;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }
}
