package com.lele.apps.cms.server;

import com.lele.apps.cms.bean.Role;
import com.lele.apps.cms.utils.CustomerException;

import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @InterfaceName IRoleService
 * @date 2019-11-19 16:04
 * @description 角色service层的业务处理接口
 */

public interface IRoleService {
    
    /**
     * 查询所有角色的方法
     * @return 返回集合，集合中是所有的角色对象
     */
    List<Role> findAll();
    
    /**
     * 添加一个角色的方法
     * @param role 角色对象
     * @throws CustomerException 可能抛出添加失败的异常
     */
    void addRole(Role role) throws CustomerException;
    
    /**
     * 保存挥着更新角色的方法
     * @param role
     * @throws CustomerException
     */
    void saveOrUpdate(Role role)throws CustomerException;
    
    /**
     * 删除一个角色的方法
     * @param role 传入可能是角色的id，或者角色的name
     */
    void deleteRole(Role role);
    
    /**
     * 更新角色的方法
     * @param role 要更新的角色的信息
     */
    void updateRole(Role role);
    
    
}
