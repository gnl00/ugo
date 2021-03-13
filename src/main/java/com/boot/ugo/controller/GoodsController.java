package com.boot.ugo.controller;

import com.boot.ugo.entity.vo.CategoryGoodsVo;
import com.boot.ugo.entity.vo.GoodsVo;
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
        List<GoodsVo> recommendGoods = goodsService.getRecommendGoods();
        PageResult homeGoods = goodsService.getHomeGoods(type, page);
        log.info(homeGoods.toString());

        goodsMap.put(RECOMMEND, recommendGoods);
        goodsMap.put(HOME, homeGoods);

        return ReturnResult.ok(goodsMap);
    }

    /**
     * search 商品搜索
     *
     * @author gnl
     * @param keyword
     * @return com.boot.ugo.vo.Result
     */
    @GetMapping("/search")
    public Result search(@RequestParam(name = "keyword") String keyword) {
        log.info(keyword);
        return ReturnResult.ok(keyword);
    }

    /**
     * getGoodsBySort 按照排序获取商品
     *
     * @author gnl
     * @param category 商品类别
     * @param sort 排序方式
     * @return com.boot.ugo.vo.Result
     */
    @GetMapping("/sort")
    public Result getGoodsBySort(@RequestParam Integer category,
                                 @RequestParam String sort){

        List<CategoryGoodsVo> goods = goodsService.getGoodsBySort(category, sort);

        if (CollectionUtils.isEmpty(goods)){
            return ReturnResult.fail(StatusCode.NOTFOUND,"根据分类获取商品失败！");
        }

        return ReturnResult.ok(goods);
    }

    @GetMapping("/{goodsId}")
    public Result getGoodsById(@PathVariable(value = "goodsId") Integer goodsId){

        Map<String, Object> goodsMap = new HashMap<>(4);

        GoodsVo goods = goodsService.getGoodsById(goodsId);

        if (goods == null){
            return ReturnResult.fail(StatusCode.NOTFOUND, "获取商品详情信息失败！");
        }

        List<GoodsVo> similarGoods = null;
        if (goods.getParentId() != null) {
            similarGoods = goodsService.getByParentId(goods.getParentId());
        }

        goodsMap.put("goods", goods.getGoods());
        goodsMap.put("picture", goods.getPicture());
        goodsMap.put("similar", similarGoods);

        return ReturnResult.ok(goodsMap);
    }


}
