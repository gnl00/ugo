package com.boot.ugo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.boot.ugo.entity.Cart;
import com.boot.ugo.entity.Customer;
import com.boot.ugo.entity.vo.CartVo;
import com.boot.ugo.service.CartService;
import com.boot.ugo.service.CustomerService;
import com.boot.ugo.utils.JwtTokenUtils;
import com.boot.ugo.vo.Result;
import com.boot.ugo.vo.ReturnResult;
import com.boot.ugo.vo.StatusCode;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * CartController
 *
 * @author gnl
 */

@Slf4j
@RestController
@RequestMapping("/ugo/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerController customerController;

    /**
     * 查看购物车
     *
     * @author gnl
     * @return com.boot.ugo.vo.Result
     */
    @GetMapping
    public Result viewCart(HttpServletRequest request) {

        Customer cartOwner = customerController.getUserFromToken(request);

        List<CartVo> cartVos = cartService.queryByCustomerId(cartOwner.getId());

        if (CollectionUtils.isEmpty(cartVos)) {
            return ReturnResult.fail(StatusCode.NOTFOUND, "操作失败");
        }

        return ReturnResult.ok(cartVos);
    }

    @GetMapping("/checked")
    public Result getCheckedCartItem(HttpServletRequest request) {

        Customer customer = customerController.getUserFromToken(request);
        List<CartVo> cartVos = cartService.getCheckedCartItem(customer.getId());

        if (!CollectionUtils.isEmpty(cartVos)) {
            return ReturnResult.ok(cartVos);
        }

        return ReturnResult.fail(StatusCode.NOTFOUND, "操作失败");
    }

    /**
     * addCart 新增购物车条目
     *
     * @author gnl
     * @param map
     * @return com.boot.ugo.vo.Result
     */
    @PostMapping
    public Result addCart(@RequestBody Map<String, Object> map, HttpServletRequest request) {

        Customer cartOwner = customerController.getUserFromToken(request);

        Integer goodsId = (Integer) map.get("goodsId");
        Integer num = (Integer) map.get("num");

        int result = cartService.addCart(cartOwner.getId(), goodsId, num);

        if (result != 1) {
            return ReturnResult.fail(StatusCode.SERVICE_UNAVAILABLE, "创建购物车失败！");
        }
        return ReturnResult.ok();
    }

    /**
     * 根据购物车Id 修改购物车信息
     *
     * @author gnl
     * @param map
     * @return com.boot.ugo.vo.Result
     */
    @PutMapping("{cartId}")
    public Result modifyCart(@PathVariable(value = "cartId") Integer cartId,
                             @RequestBody Map<String, Object> map,
                             HttpServletRequest request) {

        Integer num = (Integer) map.get("num");

        Customer cartOwner = customerController.getUserFromToken(request);

        int result = cartService.modifyCart(cartOwner.getId(), cartId, num);

        if (result!=1){
            return ReturnResult.fail(StatusCode.SERVICE_UNAVAILABLE, "操作失败！");
        }

        return ReturnResult.ok();
    }

    /**
     * 修改购物车的选中状态
     *
     * @author gnl
     * @param map
     * @return com.boot.ugo.vo.Result
     */
    @PatchMapping("/check")
    public Result checkCart(@RequestBody Map<String, Object> map) {

        // 得到前端传过来的已经选中的cartId
        List<Integer> checkedIds = (List<Integer>) map.get("cart_ids");

        List<Cart> finalCartList = new ArrayList<>();

        // 获取到数据库中所有的cart
        List<Cart> carts = cartService.list();
        List<Integer> cartIdsInDB = carts.stream().map(Cart::getId).collect(Collectors.toList());

        // 利用filter筛选出未选中的cartId
        List<Integer> unCheckedIds = cartIdsInDB.stream().filter(id -> !checkedIds.contains(id)).collect(Collectors.toList());

        List<Cart> checkedCartList = cartService.listByIds(checkedIds);

        if (!CollectionUtils.isEmpty(unCheckedIds)) {
            List<Cart> uncheckedCartList = cartService.listByIds(unCheckedIds);
            // 未选中的设为0
            uncheckedCartList.forEach(cart -> cart.setIsChecked(0));
            finalCartList.addAll(uncheckedCartList);
        }

        // 将选中的设为1
        checkedCartList.forEach(cart -> cart.setIsChecked(1));

        finalCartList.addAll(checkedCartList);
        boolean updateBatchById = cartService.updateBatchById(finalCartList);

        if (updateBatchById) {
            return ReturnResult.ok();
        } else {
            return ReturnResult.fail(StatusCode.SERVICE_UNAVAILABLE, "操作失败");
        }

    }

    /**
     * deleteCartItem
     *
     * @author gnl
     * @return com.boot.ugo.vo.Result
     */
    @DeleteMapping()
    public Result deleteCartItem(@RequestBody Map<String, Object> map) {
        Integer cartId = (Integer) map.get("cartId");
        boolean removeSuccess = cartService.removeById(cartId);

        if (removeSuccess) {
            return  ReturnResult.ok();
        }

        return ReturnResult.fail(StatusCode.SERVICE_UNAVAILABLE, "操作失败");
    }

    /**
     * 清空购物车
     *
     * @author gnl
     * @return com.boot.ugo.vo.Result
     */
    @DeleteMapping("/clear")
    public Result clear(HttpServletRequest request) {

        Customer cartOwner = customerController.getUserFromToken(request);

        return ReturnResult.ok();
    }


}
