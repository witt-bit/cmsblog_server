package com.lele.apps.cms.service;

import com.lele.apps.cms.utils.CustomerException;

import java.util.Map;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @InterfaceName IUserRoleService
 * @date 2019-11-20 09:12
 * @description 用户角色管理的接口
 */

public interface IUserRoleService {
    /**
     * 给用户设置角色的方法
     * @param map map集合，key为user_id和role_ids,value为Long[]类型
     * @throws CustomerException 设置失败的异常
     */
    void bindUserRole(Map<String,Object> map)throws CustomerException;
}
