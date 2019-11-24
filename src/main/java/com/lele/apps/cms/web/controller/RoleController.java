package com.lele.apps.cms.web.controller;

import com.lele.apps.cms.bean.Role;
import com.lele.apps.cms.bean.extend.RoleExtend;
import com.lele.apps.cms.service.IRoleService;
import com.lele.apps.cms.service.IUserRoleService;
import com.lele.apps.cms.utils.Message;
import com.lele.apps.cms.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName RoleController
 * @date 2019-11-19 15:30
 * @description 角色相关的控制器
 */
@Api(description = "角色相关的接口")
@RestController
@RequestMapping("/role")
public class RoleController {
    
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IUserRoleService userRoleService;
    
    //查询所有的角色
    @ApiOperation("查询所有的角色的方法")
    @GetMapping("findAll")
    public Message findAll () {
        
        return MessageUtil.success(roleService.findAll());
    }
    
    //添加角色的方法
    @ApiOperation("添加新角色的方法")
    @PostMapping("add")
    public Message add (Role role) {
        
        roleService.addRole(role);
        return MessageUtil.success("添加成功");
    }
    
    //删除角色的方法
    @ApiOperation("删除角色的方法")
    @PostMapping("delete")
    public Message delete (Role role) {
    
        roleService.deleteRole(role);
        return MessageUtil.success("删除成功");
    }
    
    //修改角色的方法
    @ApiOperation("修改角色信息的方法")
    @PostMapping("update")
    public Message update (Role role) {
        
        roleService.updateRole(role);
        return MessageUtil.success("修改成功");
    }
    
    //保存或者更新
    @ApiOperation("保存或者更新角色的信息")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate (Role role) {
        
        roleService.saveOrUpdate(role);
        
        if (role.getId() == null)
            return MessageUtil.success("添加成功");
        return MessageUtil.success("更新成功");
    }
    
    //给用户设置角色的方法
    @ApiOperation("给用户设置角色")
    @PostMapping(value = "setUserRole",consumes = "application/json")
    public Message setUserRole(@RequestBody Map<String,Object> map){
        userRoleService.bindUserRole(map);
        return MessageUtil.success("角色设置成功");
    }
    
    @ApiOperation("查询角色级联查询权限")
    @GetMapping("findAllIncludePrivilege")
    public Message findAllIncludePrivilege(){
        List<RoleExtend> list = roleService.findAllIncludePrivilege();
        return MessageUtil.success("查询成功",list);
    }
    
    
}
