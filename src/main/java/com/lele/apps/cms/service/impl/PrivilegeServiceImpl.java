package com.lele.apps.cms.service.impl;

import com.lele.apps.cms.bean.Privilege;
import com.lele.apps.cms.bean.PrivilegeExample;
import com.lele.apps.cms.bean.extend.LogsExtend;
import com.lele.apps.cms.bean.extend.PrivilegeExtend;
import com.lele.apps.cms.config.RecordLog;
import com.lele.apps.cms.dao.PrivilegeMapper;
import com.lele.apps.cms.dao.extend.PrivilegeExtendMapper;
import com.lele.apps.cms.service.IPrivilegeService;
import com.lele.apps.cms.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName PrivilegeServiceImpl
 * @date 2019-11-21 16:10
 * @description 权限控制实现类
 */
@Service
public class PrivilegeServiceImpl implements IPrivilegeService {
    
    @Resource
    private PrivilegeMapper privilegeMapper;
    
    @Resource
    private PrivilegeExtendMapper privilegeExtendMapper;
    
    /**
     * 查询所有权限的方法
     *
     * @return list集合
     */
    @Override
    @RecordLog({LogsExtend.LEVEL_QUERY,LogsExtend.LEVEL_INFO})
    public List<Privilege> findAll () {
        return privilegeMapper.selectByExample(new PrivilegeExample());
    }
    
    /**
     * 添加权限的方法
     *
     * @param privilege 权限对象
     * @throws CustomerException 权限可能重复的异常
     */
    @Override
    @RecordLog({LogsExtend.LEVEL_SAVE,LogsExtend.LEVEL_INFO})
    public void add (Privilege privilege) throws CustomerException {
    
    }
    
    /**
     * 删除权限的方法
     *
     * @param privilege 要删除的权限对象
     */
    @Override
    @RecordLog({LogsExtend.LEVEL_INFO,LogsExtend.LEVEL_DELETE})
    public void delete (Long id) {
        
        PrivilegeExample privilegeExample = new PrivilegeExample();
        privilegeExample.createCriteria().andIdEqualTo(id);
        List<Privilege> list = privilegeMapper.selectByExample(privilegeExample);
        if (list.size() == 0)
            throw new CustomerException("此权限已被删除");
        privilegeMapper.deleteByPrimaryKey(id);
    }
    
    /**
     * 查询所有的父目录，包含子目录
     *
     * @return 带有子目录的权限列表
     */
    @Override
    @RecordLog({LogsExtend.LEVEL_QUERY,LogsExtend.LEVEL_INFO})
    public List<PrivilegeExtend> findAllIncludeChrild () {
        return privilegeExtendMapper.selectAll();
    }
    
    /**
     * 保存或者更新权限的方法
     *
     * @param privilege 权限对象
     */
    @Override
    @RecordLog({LogsExtend.LEVEL_MODIFY,LogsExtend.LEVEL_SAVE})
    public void saveOrUpdate (Privilege privilege) {
        //判空结束
        if (privilege.getName() == null || privilege.getName().equals(""))
            throw new CustomerException("权限名称不能为空");
        
        if (privilege.getRoute() == null || privilege.getRoute().equals(""))
            throw new CustomerException("权限路径不能为空");
        
        if (privilege.getType() == null || privilege.getType().equals(""))
            throw new CustomerException("权限类型不能为空");
        
        
        if (privilege.getId() != null) {
            //更新操作
            privilegeMapper.updateByPrimaryKey(privilege);
            return;
        }
        
        // 权限名称不能重复
        PrivilegeExample example = new PrivilegeExample();
        example.createCriteria().andNameEqualTo(privilege.getName());
        List<Privilege> list = privilegeMapper.selectByExample(example);
        if (list.size() > 0)
            throw new CustomerException("权限名称不能重复");
        
        // 插入数据
        privilegeMapper.insert(privilege);
    }
    
    @Override
    @RecordLog({LogsExtend.LEVEL_QUERY,LogsExtend.LEVEL_INFO})
    public List<Privilege> selectByUserId (Long id) {
        return privilegeExtendMapper.selectByUserId(id);
    }
}
