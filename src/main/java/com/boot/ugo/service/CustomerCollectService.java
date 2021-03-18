package com.boot.ugo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.ugo.entity.CustomerCollect;
import com.boot.ugo.entity.vo.CollectVo;

import java.util.List;

/**
 * CustomerCollectService
 *
 * @author gnl
 */

public interface CustomerCollectService extends IService<CustomerCollect> {

    /**
     * listCollectVo
     *
     * @author gnl
     * @param cusId
     * @return java.util.List<com.boot.ugo.entity.vo.CollectVo>
     */
    List<CollectVo> listCollectVo(Integer cusId);

}
