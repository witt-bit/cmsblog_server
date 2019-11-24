package com.lele.apps.cms.dao.extend;

import com.lele.apps.cms.bean.Privilege;

import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @InterfaceName RolePrivilegeExtendMapper
 * @date 2019-11-21 22:40
 * @description 角色权限拓展mapper接口
 */

public interface RolePrivilegeExtendMapper {
    
    /**
     * 通过roleId查询出所有的权限信息
     * @param role_id
     * @return
     */
    List<Privilege> selectByRoleId(Long id);
}
