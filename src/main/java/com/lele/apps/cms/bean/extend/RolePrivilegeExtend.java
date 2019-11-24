package com.lele.apps.cms.bean.extend;

import com.lele.apps.cms.bean.Privilege;
import com.lele.apps.cms.bean.RolePrivilege;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName RolePrivilegeExtend
 * @date 2019-11-21 22:43
 * @description 角色权限功能拓展类
 */
public class RolePrivilegeExtend extends RolePrivilege {
    
    //级联查询出角色的权限信息
    private Privilege privileges;
    
    
    
    public Privilege getPrivileges () {
        return privileges;
    }
    
    public void setPrivileges (Privilege privileges) {
        this.privileges = privileges;
    }
}
