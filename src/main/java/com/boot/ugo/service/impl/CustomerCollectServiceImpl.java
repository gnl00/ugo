package com.boot.ugo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.ugo.entity.CustomerCollect;
import com.boot.ugo.entity.vo.CollectVo;
import com.boot.ugo.mapper.CustomerCollectMapper;
import com.boot.ugo.service.CustomerCollectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * CustomerCollectServiceImpl
 *
 * @author gnl
 */

@Slf4j
@Service
public class CustomerCollectServiceImpl extends ServiceImpl<CustomerCollectMapper, CustomerCollect> implements CustomerCollectService {

    @Resource
    CustomerCollectMapper collectMapper;

    @Override
    public List<CollectVo> listCollectVo(Integer cusId) {
        return collectMapper.selectCollectVo(cusId);
    }
}
