package com.boot.ugo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.ugo.entity.CustomerCollect;
import com.boot.ugo.mapper.CustomerCollectMapper;
import com.boot.ugo.service.CustomerCollectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * CustomerCollectServiceImpl
 *
 * @author gnl
 */

@Slf4j
@Service
public class CustomerCollectServiceImpl extends ServiceImpl<CustomerCollectMapper, CustomerCollect> implements CustomerCollectService {
}
