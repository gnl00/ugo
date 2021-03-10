package com.boot.ugo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.ugo.entity.GoodsPicture;

/**
 * GoodsPictureService
 *
 * @author gnl
 */

public interface GoodsPictureService extends IService<GoodsPicture> {

    /**
     * getOnePictureByGoodsId 根据商品id获取一张商品照片
     *
     * @author gnl
     * @param goodsId
     * @return com.boot.ugo.entity.GoodsPicture
     */
    GoodsPicture getOnePictureByGoodsId(Integer goodsId);

}
