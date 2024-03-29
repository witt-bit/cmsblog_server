package com.lele.apps.cms.dao.extend;

import com.lele.apps.cms.bean.extend.UserExtend;

import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @InterfaceName UserExtendMapper
 * @date 2019-11-18 18:47
 * @description 用户拓展功能的实现接口
 */

public interface UserExtendMapper {
    
    UserExtend selectById(Long id);
    
    UserExtend selectByUsername(String username);
    
    List<UserExtend> findAll();
    
    List<UserExtend> selectByStatus (String status);
    
    UserExtend selectByTelePhone (String tel);
}
