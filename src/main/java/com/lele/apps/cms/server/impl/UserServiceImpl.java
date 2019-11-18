package com.lele.apps.cms.server.impl;

import com.lele.apps.cms.bean.extend.UserExtend;
import com.lele.apps.cms.dao.extend.UserExtendMapper;
import com.lele.apps.cms.server.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName UserServiceImpl
 * @date 2019-11-18 19:13
 * @description 用户service的实现类
 */
@Service
public class UserServiceImpl implements IUserService {
    
    @Resource
    private UserExtendMapper userExtendMapper;
    
    /**
     * 通过id查询用户信息的方法
     *
     * @param id 用户的id
     * @return 用户的信息，包括级联查询的角色信息
     */
    @Override
    public UserExtend findById (Long id) {
        return userExtendMapper.selectById(id);
    }
}
