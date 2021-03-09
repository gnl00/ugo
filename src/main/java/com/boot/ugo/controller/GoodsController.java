package com.boot.ugo.controller;

import com.boot.ugo.entity.Goods;
import com.boot.ugo.service.GoodsService;
import com.boot.ugo.vo.Result;
import com.boot.ugo.vo.ReturnResult;
import com.boot.ugo.vo.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * GoodsController
 *
 * @author gnl
 */

@CrossOrigin
@RestController
@RequestMapping("/ugo/goo")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    /**
     * 获取到首页关于goods的数据
     *
     * @author gnl
     * @return com.boot.ugo.vo.ReturnResult
     */
    @GetMapping("/index")
    public Result index() {

        // 获取到推荐数据
        List<Goods> recommendGoods = goodsService.getRecommendGoods();
        if (null == recommendGoods || CollectionUtils.isEmpty(recommendGoods)){
            return ReturnResult.fail(StatusCode.NOTFOUND, "操作失败");
        }
        return ReturnResult.ok(recommendGoods);
    }

}
