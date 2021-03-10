package com.boot.ugo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.ugo.entity.Goods;
import com.boot.ugo.entity.vo.HomeGoodsVo;
import com.boot.ugo.vo.PageResult;
import org.apache.ibatis.javassist.NotFoundException;

import java.util.List;

/**
 * GoodsService
 *
 * @author gnl
 */

public interface GoodsService extends IService<Goods> {

    /**
     * 获取首页推荐数据
     * @throws NotFoundException
     * @author gnl
     * @return java.util.List<com.boot.ugo.entity.Goods>
     */
    List<HomeGoodsVo> getRecommendGoods() throws NotFoundException;

    /**
     * 分页获取首页选项卡数据
     *
     * @author gnl
     * @param type
     * @param page
     * @throws NotFoundException
     * @return com.boot.ugo.vo.PageResult;
     * @date 2021/3/10 11:49
     */
    PageResult getHomeGoods(String type, long page) throws NotFoundException;

}
