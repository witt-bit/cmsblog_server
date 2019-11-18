package com.lele.apps.cms.bean.extend;

import com.lele.apps.cms.bean.Role;
import com.lele.apps.cms.bean.User;

import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName UserExtend
 * @date 2019-11-18 15:31
 * @description 用户功能拓展类
 */
public class UserExtend extends User {
    
    private List<Role> roles;
    
    public List<Role> getRoles () {
        return roles;
    }
    
    public void setRoles (List<Role> roles) {
        this.roles = roles;
    }
}
