package com.lele.apps.cms.service;

import com.lele.apps.cms.bean.Privilege;
import com.lele.apps.cms.bean.extend.PrivilegeExtend;
import com.lele.apps.cms.utils.CustomerException;

import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @InterfaceName IPrivilegeService
 * @date 2019-11-19 23:39
 * @description 权限管理的service层接口
 */

public interface IPrivilegeService {
    /**
     * 查询所有权限的方法
     * @return list集合
     */
    List<Privilege> findAll();
    
    /**
     * 添加权限的方法
     * @param privilege 权限对象
     * @throws CustomerException 权限可能重复的异常
     */
    void add(Privilege privilege)throws CustomerException;
    
    /**
     * 删除权限的方法
     * @param privilege 要删除的权限对象
     */
    void delete(Long id);
    
    /**
     * 查询所有的父目录，包含子目录
     * @return 带有子目录的权限列表
     */
    List<PrivilegeExtend> findAllIncludeChrild ();
    
    /**
     * 保存或者更新权限的方法
     * @param privilege 权限对象
     */
    void saveOrUpdate (Privilege privilege);
    
    List<Privilege> selectByUserId(Long id);
}
