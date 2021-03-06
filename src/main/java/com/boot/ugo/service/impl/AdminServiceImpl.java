package com.boot.ugo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.ugo.entity.Admin;
import com.boot.ugo.mapper.AdminMapper;
import com.boot.ugo.service.AdminService;
import org.springframework.stereotype.Service;

/**
 * AdminServiceImpl
 *
 * @author gnl
 */

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
}
