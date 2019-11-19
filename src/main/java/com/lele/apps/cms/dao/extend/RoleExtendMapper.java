package com.lele.apps.cms.dao.extend;

import com.lele.apps.cms.bean.Role;
import com.lele.apps.cms.bean.User;

import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @InterfaceName RoleExtendMapper
 * @date 2019-11-18 18:52
 * @description 角色功能拓展映射接口
 */

public interface RoleExtendMapper {
    
    //通过用户id查找对应的角色
    List<Role> selectByUserId(Long userId);
    
    Role selectByName (String reader);
    
    List<User> cascUserByName(String name);
    
    int deleteByName (String name);
}
