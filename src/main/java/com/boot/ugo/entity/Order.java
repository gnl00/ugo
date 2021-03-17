package com.boot.ugo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@TableName(value = "customer_order")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单明细Id
     */
    private Integer detailId;

    /**
     * 订单所属用户Id
     */
    private Integer customerId;

    /**
     * 下单日期
     */
    private long orderTime;

    /**
     * 订单支付状态
     * 1 已支付
     * 0 未支付
     */
    private int paymentStatus;

    /**
     * 订单支付时间
     */
    private long paymentTime;

    /**
     * 订单结单日期
     */
    private long endTime;

    /**
     * 订单状态
     * 0 未支付，未完成
     * 1 已支付，未完成
     * 2 已支付，已完成
     */
    private int orderStatus;


    public Order(Integer detailId, Integer customerId, long orderTime) {
        this.detailId = detailId;
        this.customerId = customerId;
        this.orderTime = orderTime;
    }
}
