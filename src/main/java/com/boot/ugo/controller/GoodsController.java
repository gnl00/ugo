package com.boot.ugo.controller;

import com.boot.ugo.entity.Goods;
import com.boot.ugo.entity.vo.HomeGoodsVo;
import com.boot.ugo.service.GoodsService;
import com.boot.ugo.vo.PageResult;
import com.boot.ugo.vo.Result;
import com.boot.ugo.vo.ReturnResult;
import com.boot.ugo.vo.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GoodsController
 *
 * @author gnl
 */

@Slf4j
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
    public Result index(@RequestParam(name = "type", defaultValue = "hot", required = false) String type,
                        @RequestParam(name = "page", defaultValue = "1", required = false) long page) throws NotFoundException {

        final String RECOMMEND = "recommend";
        final String HOME = "home";

        Map<String, Object> goodsMap = new HashMap<>(4);

        // 获取首页推荐商品数据
        List<HomeGoodsVo> recommendGoods = goodsService.getRecommendGoods();
        PageResult homeGoods = goodsService.getHomeGoods(type, page);
        log.info(homeGoods.toString());

        goodsMap.put(RECOMMEND, recommendGoods);
        goodsMap.put(HOME, homeGoods);

        return ReturnResult.ok(goodsMap);
    }


}
