package com.lele.apps.cms.web.controller;

import com.lele.apps.cms.service.IRolePrivilegeService;
import com.lele.apps.cms.utils.Message;
import com.lele.apps.cms.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName RolePrivilegeController
 * @date 2019-11-21 23:47
 * @description 角色权限关联相关的控制借口
 */
@Api(description = "角色权限关联的相关控制借口")
@RestController
@RequestMapping("/roleprivilege")
public class RolePrivilegeController {
    
    @Autowired
    private IRolePrivilegeService rolePrivilegeService;
    
    @ApiOperation("给角色绑定权限的控制器")
    @PostMapping("setPrivilege")
    public Message setPrivilege (Long id, Long[] privileges) {
        rolePrivilegeService.bindRolePrivileges(id, privileges);
        return MessageUtil.success("设置成功");
    }
}
