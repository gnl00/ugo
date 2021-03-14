package com.boot.ugo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.ugo.entity.Cart;
import com.boot.ugo.entity.vo.CartVo;

import java.util.List;

/**
 * CartMapper
 *
 * @author gnl
 */

public interface CartMapper extends BaseMapper<Cart> {

    /**
     * getAllByCustomerId 根据用户Id查询对应的购物车内容
     *
     * @author gnl
     * @param cusId
     * @return java.util.List<com.boot.ugo.entity.vo.CartVo>
     */
    List<CartVo> getByCustomerId(Integer cusId);

}
