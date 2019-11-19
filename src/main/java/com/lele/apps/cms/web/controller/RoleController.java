package com.lele.apps.cms.web.controller;

import com.lele.apps.cms.bean.Role;
import com.lele.apps.cms.server.IRoleService;
import com.lele.apps.cms.utils.Message;
import com.lele.apps.cms.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
    //查询所有的角色
    @ApiOperation("查询所有的角色的方法")
    @GetMapping("findAll")
    public Message findAll () {
        
        return MessageUtil.success(roleService.findAll());
    }
    
    //添加角色的方法
    @ApiOperation("添加角色的方法")
    @PostMapping("add")
    public Message add (Role role) {
        roleService.addRole(role);
        return MessageUtil.success("添加成功");
    }
    
    //删除角色的方法
    @ApiOperation("删除角色的方法")
    @GetMapping("delete")
    public Message delete (Role role) {
        roleService.deleteRole(role);
        return MessageUtil.success("删除成功");
    }
    
    //修改角色的方法
    @ApiOperation("修改角色信息的方法")
    @PostMapping("")
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
}
