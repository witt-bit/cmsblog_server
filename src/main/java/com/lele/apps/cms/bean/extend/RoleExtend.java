package com.lele.apps.cms.bean.extend;

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
public class RoleExtend {
    
    //默认角色
    public static final String READER = "reader";
    public static final String EDITOR = "editor";
    public static final String ADMINISTRATOR = "admin";
    
    private List<UserRole> userRoles;
    
    public List<UserRole> getUserRoles () {
        return userRoles;
    }
    
    public void setUserRoles (List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
