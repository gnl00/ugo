package com.boot.ugo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.boot.ugo.entity.*;
import com.boot.ugo.entity.vo.CartVo;
import com.boot.ugo.service.*;
import com.boot.ugo.vo.Result;
import com.boot.ugo.vo.ReturnResult;
import com.boot.ugo.vo.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * OrderController
 *
 * @author gnl
 */

@Slf4j
@RestController
@RequestMapping("/ugo/ord")
public class OrderController {

    @Autowired
    CustomerController customerController;

    @Autowired
    OrderService orderService;

    @Autowired
    CartService cartService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderDetailService detailService;

    /**
     * 从购物车下单
     *
     * @author gnl
     * @param request
     * @return com.boot.ugo.vo.Result
     */
    @PostMapping("/create")
    public Result createOrder(HttpServletRequest request) {
        Customer customer = customerController.getUserFromToken(request);

        // 从数据库中购物车表找到已经勾选的商品
        QueryWrapper<Cart> cartWrapper = new QueryWrapper<>();
        cartWrapper.eq("is_checked", 1);
        List<Cart> cartCheckedItems = cartService.list(cartWrapper);

        List<Goods> goodsList = new ArrayList<>();
        List<Order> orderList = new ArrayList<>();

        boolean saveGoods = false;
        boolean saveDetail = false;
        boolean saveOrder = false;

        long orderTime = System.currentTimeMillis();

        // 修改商品库存时加锁
        // this 指的是当前对象
        // OrderController由Spring容器管理，默认生成的对象为单例对象，因此锁资源 this 只有一个
        synchronized (this) {
            for (Cart cartItem : cartCheckedItems) {
                // 修改商品库存
                Goods goods = goodsService.getById(cartItem.getGoodsId());

                Integer goodsAmount = goods.getAmount() - cartItem.getQuantity();

                if (goodsAmount > 0) {
                    goods.setAmount(goods.getAmount() - cartItem.getQuantity());

                    // 生成订单明细
                    OrderDetail detail = new OrderDetail(cartItem.getGoodsId(), cartItem.getQuantity(), cartItem.getPrice(), cartItem.getTotal());

                    // 保存商品明细 并返回id
                    int detailId = detailService.saveAndReturnId(detail);
                    Order order = new Order(detailId, cartItem.getCustomerId(), orderTime);

                    goodsList.add(goods);
                    orderList.add(order);
                } else {
                    return ReturnResult.fail(StatusCode.SERVICE_UNAVAILABLE, "商品库存不足");
                }
            }
        }

        // 保存已经修改库存的商品
        saveGoods = goodsService.updateBatchById(goodsList);

        // 保存订单
        saveOrder = orderService.saveBatch(orderList);

        // 将订单信息返回
        List<CartVo> cartVos = cartService.getCheckedCartItem(customer.getId());

        List<Integer> checkedIds = cartCheckedItems.stream().map(Cart::getId).collect(Collectors.toList());
        // 将下单的商品从购物车删除
        boolean removeFromCart = cartService.removeByIds(checkedIds);

        if (saveGoods && saveDetail && saveOrder && removeFromCart && !CollectionUtils.isEmpty(cartVos)) {
            return ReturnResult.ok(cartVos);
        }

        return ReturnResult.fail(StatusCode.SERVICE_UNAVAILABLE, "操作失败");
    }

}
