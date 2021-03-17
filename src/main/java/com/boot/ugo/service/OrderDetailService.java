package com.boot.ugo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.ugo.entity.OrderDetail;

/**
 * OrderDetailService
 *
 * @author gnl
 */

public interface OrderDetailService extends IService<OrderDetail> {

    /**
     * insertAndReturnId 保存商品明细 并返回自增的id
     *
     * @author gnl
     * @param detail
     * @return int
     */
    int saveAndReturnId(OrderDetail detail);

}
