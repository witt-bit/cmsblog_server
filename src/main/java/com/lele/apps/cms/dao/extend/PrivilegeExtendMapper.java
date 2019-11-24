package com.lele.apps.cms.dao.extend;

import com.lele.apps.cms.bean.Privilege;
import com.lele.apps.cms.bean.extend.PrivilegeExtend;

import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @InterfaceName PrivilegeExtendMapper
 * @date 2019-11-21 16:25
 * @description 权限控制的拓展数据层接口
 */

public interface PrivilegeExtendMapper {
    /**
     * 查询权限列表，父列表包含子列表
     * @return
     */
    List<PrivilegeExtend> selectAll();
    
    /**
     * 通过parent_id查询当前父目录下的所有子目录
     * @return 所有的子目录
     */
    Privilege selectByParentId(Long id);
    
    List<Privilege> selectByUserId (Long id);
}
