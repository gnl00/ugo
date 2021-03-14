package com.boot.ugo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import java.util.List;
import java.util.Map;

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

    /**
     * 查看购物车
     *
     * @author gnl
     * @return com.boot.ugo.vo.Result
     */
    @GetMapping
    public Result viewCart(HttpServletRequest request) {
        log.info("... cart viewCart");

        Customer cartOwner = getCartOwner(request);

        List<CartVo> cartVos = cartService.queryByCustomerId(cartOwner.getId());

        if (CollectionUtils.isEmpty(cartVos)) {
            return ReturnResult.fail(StatusCode.SERVICE_UNAVAILABLE, "操作失败");
        }

        return ReturnResult.ok(cartVos);
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
        log.info("... cart addCart");

        log.info(map.toString());

        Customer cartOwner = getCartOwner(request);

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
        log.info("... cart modifyCart");

        Integer num = (Integer) map.get("num");

        Customer cartOwner = getCartOwner(request);

        int result = cartService.modifyCart(cartOwner.getId(), cartId, num);

        if (result!=1){
            return ReturnResult.fail(StatusCode.SERVICE_UNAVAILABLE, "操作失败！");
        }

        return ReturnResult.ok();
    }

    /**
     * 清空购物车
     *
     * @author gnl
     * @return com.boot.ugo.vo.Result
     */
    @DeleteMapping
    public Result clear(HttpServletRequest request) {

        log.info("... cart clear");

        Customer cartOwner = getCartOwner(request);

        return ReturnResult.ok();
    }

    /**
     * 从token中获取到用户信息
     *
     * @author gnl
     * @param request
     * @return com.boot.ugo.entity.Customer
     */
    private Customer getCartOwner(HttpServletRequest request) {

        String token = request.getHeader(JwtTokenUtils.JWT_HEADER).replace(JwtTokenUtils.JWT_PREFIX, "");
        String username = JwtTokenUtils.getTokenSubject(token);

        QueryWrapper<Customer> wrapper = new QueryWrapper<>();
        wrapper.eq("nick_name", username);
        Customer cartOwner = customerService.getOne(wrapper);

        return cartOwner;
    }

}
