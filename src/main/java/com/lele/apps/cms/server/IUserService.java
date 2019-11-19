package com.lele.apps.cms.server;

import com.lele.apps.cms.bean.User;
import com.lele.apps.cms.bean.extend.UserExtend;

import java.util.List;

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
    
    /**
     * 通过username查询用户的详细信息
     * @param username 传入一个username的字符串
     * @return user对象，包括级联查询的信息
     */
    UserExtend findByUsername(String username);
    
    /**
     * 通过电话号码查询用户
     * @param tel 传入电话号码
     * @return 返回用户对象，包括角色
     */
    UserExtend findByTel(String tel);
    
    /**
     * 保存和更新用户
     * @param user 修改的用户的信息
     */
    void saveOrUpdate(User user);
    
    /**
     * 删除用户通过id
     * @param id
     */
    void deleteById(Long id);
    
    /**
     * 筛选显示用户信息，包括级联查询的信息
     * @param rule 传入的规则(编辑，管理员，禁用或者启用字符串)
     * @return 用户详细信息的集合
     */
     List<? super UserExtend> screening(String rule);
    
}
