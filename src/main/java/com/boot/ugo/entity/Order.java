package com.boot.ugo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Order 订单实体类
 *
 * @author gnl
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Integer id;

    /**
     * 订单明细Id
     */
    private Integer orderDetailId;

    /**
     * 订单所属用户Id
     */
    private Integer customerId;

    /**
     * 购买商品总数
     */
    private Integer quantity;

    /**
     * 订单总额
     */
    private BigDecimal total;

    /**
     * 下单日期
     */
    private Date orderDate;

    /**
     * 订单状态
     * 1. 未支付，未完成
     * 2. 已支付，未完成
     * 3. 已支付，已完成
     */
    private String orderStatus;

    /**
     * 订单支付状态
     * 1. yes
     * 2. no
     */
    private String paymentStatus;

    /**
     * 订单支付时间
     */
    private Date paymentTime;

    /**
     * 订单结单日期
     */
    private Date endDate;

}
