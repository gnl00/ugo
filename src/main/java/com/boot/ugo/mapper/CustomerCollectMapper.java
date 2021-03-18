package com.boot.ugo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.ugo.entity.CustomerCollect;
import com.boot.ugo.entity.vo.CollectVo;

import java.util.List;

/**
 * CustomerCollectMapper
 *
 * @author gnl
 */

public interface CustomerCollectMapper extends BaseMapper<CustomerCollect> {

    /**
     * selectCollectVo
     *
     * @author gnl
     * @param cusId
     * @return java.util.List<com.boot.ugo.entity.vo.CollectVo>
     */
    List<CollectVo> selectCollectVo(Integer cusId);

}
