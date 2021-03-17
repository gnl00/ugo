package com.boot.ugo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.ugo.entity.OrderDetail;

/**
 * OrderDetailMapper
 *
 * @author gnl
 */

public interface OrderDetailMapper extends BaseMapper<OrderDetail> {

    /**
     * insertAndReturnId 保存商品明细 并返回自增的id
     *
     * @author gnl
     * @param detail
     * @return int
     */
    int insertAndReturnId(OrderDetail detail);

}
