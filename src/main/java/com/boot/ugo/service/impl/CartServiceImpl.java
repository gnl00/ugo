package com.boot.ugo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.ugo.entity.Cart;
import com.boot.ugo.entity.Goods;
import com.boot.ugo.entity.vo.CartVo;
import com.boot.ugo.mapper.CartMapper;
import com.boot.ugo.mapper.CustomerMapper;
import com.boot.ugo.mapper.GoodsMapper;
import com.boot.ugo.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sound.sampled.Line;
import java.math.BigDecimal;
import java.util.List;

/**
 * CartServiceImpl
 *
 * @author gnl
 */

@Slf4j
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    @Resource
    CartMapper cartMapper;

    @Resource
    GoodsMapper goodsMapper;

    @Override
    public List<CartVo> queryByCustomerId(Integer cusId) {
        return cartMapper.getByCustomerId(cusId);
    }

    @Override
    public int addCart(Integer cusId, Integer goodsId, Integer num) {

        QueryWrapper<Goods> goodsWrapper = new QueryWrapper<>();
        goodsWrapper.eq("id", goodsId);
        Goods goods = goodsMapper.selectOne(goodsWrapper);

        QueryWrapper<Cart> cartWrapper = new QueryWrapper<>();
        cartWrapper.eq("customer_id", cusId).eq("goods_id", goodsId);
        Cart cartInDB = cartMapper.selectOne(cartWrapper);

        if (null == cartInDB) {
            Cart cart = new Cart(null,cusId, goodsId, num, goods.getPrice(), goods.getPrice().multiply(BigDecimal.valueOf(num)));
            return cartMapper.insert(cart);
        } else {
            return modifyCart(cusId, cartInDB.getId(),num);
        }

    }

    @Override
    public int modifyCart(Integer cusId, Integer cartId, Integer num) {

        // 在数据库中找到对应的cart条目
        QueryWrapper<Cart> wrapper = new QueryWrapper<>();
        wrapper.eq("id", cartId).eq("customer_id", cusId);
        Cart cartInDB = cartMapper.selectOne(wrapper);

        cartInDB.setQuantity(cartInDB.getQuantity() + num );
        cartInDB.setTotal(cartInDB.getPrice().multiply(BigDecimal.valueOf(cartInDB.getQuantity())));

        return cartMapper.updateById(cartInDB);
    }
}
