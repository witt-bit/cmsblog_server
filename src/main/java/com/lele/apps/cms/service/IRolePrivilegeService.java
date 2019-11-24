package com.lele.apps.cms.service;

import com.lele.apps.cms.utils.CustomerException;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @InterfaceName IRolePrivilegeService
 * @date 2019-11-21 23:49
 * @description 角色权限的service层接口
 */

public interface IRolePrivilegeService {
    
    /**
     * 给角色设置权限的方法
     * @param role_id 需要设置的角色的id
     * @param privilege_ids 给角色设置的权限的id的数组
     * @throws CustomerException 可能抛出自定义的错误异常
     */
    void bindRolePrivileges(Long role_id,Long[] privilege_ids)throws CustomerException;

}
