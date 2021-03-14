package com.boot.ugo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.ugo.entity.Cart;
import com.boot.ugo.entity.vo.CartVo;

import java.util.List;

/**
 * CartService
 *
 * @author gnl
 */

public interface CartService extends IService<Cart> {

    /**
     * queryByCustomerId 根据用户id查询对应的购物车数据
     *
     * @author gnl
     * @param cusId
     * @return java.util.List<com.boot.ugo.entity.vo.CartVo>
     */
    List<CartVo> queryByCustomerId(Integer cusId);

    /**
     * addCart 新增购物车条目
     *
     * @author gnl
     * @param cusId
     * @param goodsId
     * @param num
     * @return int
     */
    int addCart(Integer cusId, Integer goodsId, Integer num);

    /**
     * modifyCart 根据购物车Id 修改购物车信息
     *
     * @author gnl
     * @param cusId
     * @param cartId
     * @param num
     * @return int
     * @date 2021/3/14 13:26
     */
    int modifyCart(Integer cusId, Integer cartId, Integer num);

}
