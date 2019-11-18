package com.lele.apps.cms.dao;

import com.lele.apps.cms.bean.RolePrivilege;
import com.lele.apps.cms.bean.RolePrivilegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePrivilegeMapper {
    long countByExample(RolePrivilegeExample example);

    int deleteByExample(RolePrivilegeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RolePrivilege record);

    int insertSelective(RolePrivilege record);

    List<RolePrivilege> selectByExample(RolePrivilegeExample example);

    RolePrivilege selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RolePrivilege record, @Param("example") RolePrivilegeExample example);

    int updateByExample(@Param("record") RolePrivilege record, @Param("example") RolePrivilegeExample example);

    int updateByPrimaryKeySelective(RolePrivilege record);

    int updateByPrimaryKey(RolePrivilege record);
}