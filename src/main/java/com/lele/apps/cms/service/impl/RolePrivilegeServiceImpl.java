package com.lele.apps.cms.service.impl;

import com.lele.apps.cms.bean.RolePrivilege;
import com.lele.apps.cms.bean.RolePrivilegeExample;
import com.lele.apps.cms.dao.RolePrivilegeMapper;
import com.lele.apps.cms.dao.extend.RolePrivilegeExtendMapper;
import com.lele.apps.cms.service.IRolePrivilegeService;
import com.lele.apps.cms.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName RolePrivilegeServiceImpl
 * @date 2019-11-21 23:55
 * @description 角色权限接口实现类
 */
@Service
public class RolePrivilegeServiceImpl implements IRolePrivilegeService {
    
    @Resource
    private RolePrivilegeExtendMapper rolePrivilegeExtendMapper;
    
    @Resource
    private RolePrivilegeMapper rolePrivilegeMapper;
    
    /**
     * 给角色设置权限的方法
     *
     * @param role_id       需要设置的角色的id
     * @param privilege_ids 给角色设置的权限的id的数组
     * @throws CustomerException 可能抛出自定义的错误异常
     */
    @Override
    public void bindRolePrivileges (Long role_id, Long[] privilege_ids) throws CustomerException {
        if(role_id==null)
            throw new CustomerException("请选择需要设置权限的角色");
    
        RolePrivilegeExample rolePrivilegeExample = new RolePrivilegeExample();
        rolePrivilegeExample.createCriteria().andRoleIdEqualTo(role_id);
    
        List<RolePrivilege> list = rolePrivilegeMapper.selectByExample(rolePrivilegeExample);
        // 角色有原来的权限是否存在
        if(list.size()!=0){
            // 删除角色原来的所有权限
            rolePrivilegeMapper.deleteByExample(rolePrivilegeExample);
            return;
        }
        
        // 如果没有选择任何权限
        if(privilege_ids==null||privilege_ids.length==0)
            throw new CustomerException("请选择至少一个权限");
        
        // 将当前选择的所有权限插入
        for (Long id:privilege_ids){
            RolePrivilege rolePrivilege = new RolePrivilege();
            rolePrivilege.setRoleId(role_id);
            rolePrivilege.setPrivilegeId(id);
            rolePrivilegeMapper.insert(rolePrivilege);
        }
    
    
    }
}
