package com.lele.apps.cms.server;

import com.lele.apps.cms.bean.extend.UserExtend;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @InterfaceName IUserService
 * @date 2019-11-18 19:12
 * @description 用户的Service层接口
 */

public interface IUserService {
    
    /**
     * 通过id查询用户信息的方法
     * @param id  用户的id
     * @return 用户的信息，包括级联查询的角色信息
     */
    UserExtend findById(Long id);
    
}
