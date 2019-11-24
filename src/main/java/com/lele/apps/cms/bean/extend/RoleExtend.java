package com.lele.apps.cms.bean.extend;

import com.lele.apps.cms.bean.Privilege;
import com.lele.apps.cms.bean.Role;
import com.lele.apps.cms.bean.UserRole;

import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName RoleExtend
 * @date 2019-11-18 23:46
 * @description 角色类功能拓展类
 */
public class RoleExtend extends Role {
    
    //默认角色
    public static final String READER = "reader";
    public static final String EDITOR = "editor";
    public static final String ADMINISTRATOR = "admin";
    
    // 查询角色的时候 查出来使用该角色的用户
    private List<UserRole> userRoles;
    
    // 查询该角色的权限
    private List<Privilege> privileges;
    
    public List<UserRole> getUserRoles () {
        return userRoles;
    }
    
    public void setUserRoles (List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
    
    public List<Privilege> getPrivileges () {
        return privileges;
    }
    
    public void setPrivileges (List<Privilege> privileges) {
        this.privileges = privileges;
    }
}
