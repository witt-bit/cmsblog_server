package com.lele.apps.cms.service.impl;

import com.lele.apps.cms.bean.Role;
import com.lele.apps.cms.bean.RoleExample;
import com.lele.apps.cms.bean.extend.LogsExtend;
import com.lele.apps.cms.bean.extend.RoleExtend;
import com.lele.apps.cms.config.RecordLog;
import com.lele.apps.cms.dao.RoleMapper;
import com.lele.apps.cms.dao.extend.RoleExtendMapper;
import com.lele.apps.cms.service.IRoleService;
import com.lele.apps.cms.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName RoleServiceImpl
 * @date 2019-11-19 16:16
 * @description 角色service的实现类
 */
@Service
public class RoleServiceImpl implements IRoleService {
    
    @Resource
    private RoleMapper roleMapper;
    
    @Resource
    private RoleExtendMapper roleExtendMapper;
    
    /**
     * 查询所有角色的方法
     *
     * @return 返回集合，集合中是所有的角色对象
     */
    @Override
    @RecordLog({LogsExtend.LEVEL_INFO,LogsExtend.LEVEL_DELETE})
    public List<Role> findAll () {
        
        return roleMapper.selectByExample(new RoleExample());
    }
    
    /**
     * 添加一个角色的方法
     *
     * @param role 角色对象
     * @throws CustomerException 可能抛出添加失败的异常
     */
    @Override
    @RecordLog({LogsExtend.LEVEL_SAVE,LogsExtend.LEVEL_INFO})
    public void addRole (Role role) throws CustomerException {
        
        String name = role.getName();
        if (name == null || name.isEmpty())
            throw new CustomerException("角色名称不能为空");
        Role roleForDB = roleExtendMapper.selectByName(name);
        if (roleForDB != null)
            throw new CustomerException("该角色已经存在了");
        
        roleMapper.insert(role);
    }
    
    /**
     * 删除一个角色的方法
     *
     * @param role 传入可能是角色的id，或者角色的name
     */
    @Override
    @RecordLog({LogsExtend.LEVEL_INFO,LogsExtend.LEVEL_DELETE})
    public void deleteRole (Role role) {
        
        
        if (role == null)
            throw new CustomerException("请输入角色名称或者角色id");
        if (role.getId() != null) {
            roleMapper.deleteByPrimaryKey(role.getId());
            return;
        }
        if (role.getName() != null) {
            roleExtendMapper.deleteByName(role.getName());
        }
        
    }
    
    /**
     * 更新角色的方法
     *
     * @param role 要更新的角色的信息
     */
    @Override
    @RecordLog({LogsExtend.LEVEL_SAVE,LogsExtend.LEVEL_INFO})
    public void updateRole (Role role) {
        roleMapper.updateByPrimaryKey(role);
    }
    
    /**
     * 保存或者更新角色的方法
     *
     * @param role
     * @throws CustomerException
     */
    @Override
    @RecordLog({LogsExtend.LEVEL_SAVE,LogsExtend.LEVEL_MODIFY})
    public void saveOrUpdate (Role role) throws CustomerException {
        if (role.getId() != null){
            //更新
            roleMapper.updateByPrimaryKey(role);
            return;
        }
        //保存操作
        if (role.getName() == null || role.getName().isEmpty())
            throw new CustomerException("角色名称不能为空");
        //查询一遍
        Role roleForDB = roleExtendMapper.selectByName(role.getName());
        if (roleForDB != null)
            throw new CustomerException("该角色已经存在了");
    
        roleMapper.insert(role);
    }
    
    /**
     * 查询所有的角色，包含角色的权限
     *
     * @return
     */
    @Override
    @RecordLog({LogsExtend.LEVEL_SAVE,LogsExtend.LEVEL_INFO})
    public List<RoleExtend> findAllIncludePrivilege () {
        return roleExtendMapper.selectAllIncludePrivilege();
    }
}
