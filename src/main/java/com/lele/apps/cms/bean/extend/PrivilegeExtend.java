package com.lele.apps.cms.bean.extend;

import com.lele.apps.cms.bean.Privilege;

import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName PrivilegeExtend
 * @date 2019-11-19 23:47
 * @description 权限功能拓展类
 */
public class PrivilegeExtend extends Privilege {
    
    // 关联查看父级权限
    private List<Privilege> children;
    
    public List<Privilege> getChildren () {
        return children;
    }
    
    public void setChildren (List<Privilege> children) {
        this.children = children;
    }
}
