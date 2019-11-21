package com.lele.apps.cms.service.impl;

import com.lele.apps.cms.bean.UserRole;
import com.lele.apps.cms.bean.UserRoleExample;
import com.lele.apps.cms.dao.UserRoleMapper;
import com.lele.apps.cms.service.IUserRoleService;
import com.lele.apps.cms.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName UserRoleServiceImpl
 * @date 2019-11-20 09:19
 * @description 用户设置角色的Service接口实现类
 */
@Service
public class UserRoleServiceImpl implements IUserRoleService {
    
    @Resource
    private UserRoleMapper userRoleMapper;
    
    /**
     * 给用户设置角色的方法
     *
     * @param map map集合，key为user_id和role_ids,value为Long[]类型
     * @throws CustomerException 设置失败的异常
     */
    @Override
    public void bindUserRole (Map<String, Object> map) throws CustomerException {
        //把用户的id和当前要设置的所有的角色拿出来
        Long user_id = Long.parseLong(map.get("user_id")+"");
        List<Integer> role_ids = (List<Integer>) map.get("role_ids");
        
        //查看旧的角色
        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria().andUserIdEqualTo(user_id);
        
        List<UserRole> oldUserRoles = userRoleMapper.selectByExample(userRoleExample);
        //该用户有旧的权限，删除所有旧的权限
        if (oldUserRoles.size() != 0) {
            userRoleMapper.deleteByExample(userRoleExample);
        }
        // 什么角色都不选，直接结束方法
        if (role_ids.size() == 0) {
            return;
        }
    
        //该用户没有任何角色
        //把当前的角色全部插入进去
        for (Integer role_id : role_ids) {
            UserRole userRole = new UserRole();
            userRole.setUserId(user_id);
            userRole.setRoleId(Long.parseLong(role_id+""));
            userRoleMapper.insert(userRole);
        }
    }
}
