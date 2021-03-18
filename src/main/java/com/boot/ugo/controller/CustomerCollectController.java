package com.boot.ugo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.boot.ugo.entity.Customer;
import com.boot.ugo.entity.CustomerCollect;
import com.boot.ugo.entity.vo.CollectVo;
import com.boot.ugo.service.CustomerCollectService;
import com.boot.ugo.vo.Result;
import com.boot.ugo.vo.ReturnResult;
import com.boot.ugo.vo.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * CustomerCollectController
 *
 * @author gnl
 */

@Slf4j
@RestController
@RequestMapping("/ugo/col")
public class CustomerCollectController {

    @Autowired
    CustomerCollectService collectService;

    @Autowired
    CustomerController customerController;

    @GetMapping("/all")
    public Result getAllCollections(HttpServletRequest request) {
        Customer customer = customerController.getUserFromToken(request);

        List<CollectVo> collectVos = collectService.listCollectVo(customer.getId());

        return ReturnResult.ok(collectVos);

    }

    @PostMapping("/add/{goodsId}")
    public Result addCollection(@PathVariable Integer goodsId, HttpServletRequest request) {
        Customer customer = customerController.getUserFromToken(request);
        boolean saveToCollection = collectService.save(new CustomerCollect(customer.getId(), goodsId));

        if (saveToCollection) {
            return ReturnResult.ok();
        }

        return ReturnResult.fail(StatusCode.SERVICE_UNAVAILABLE, "操作失败");
    }

    @DeleteMapping("/rm/{goodsId}")
    public Result removeCollection(@PathVariable Integer goodsId, HttpServletRequest request) {
        Customer customer = customerController.getUserFromToken(request);

        QueryWrapper<CustomerCollect> wrapper = new QueryWrapper<>();
        wrapper.eq("customer_id", customer.getId()).eq("goods_id", goodsId);
        boolean remove = collectService.remove(wrapper);

        if (remove) {
            return ReturnResult.ok();
        }
        return ReturnResult.fail(StatusCode.SERVICE_UNAVAILABLE, "操作失败");
    }

}
