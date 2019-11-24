package com.lele.apps.cms.web.controller;

import com.lele.apps.cms.bean.Privilege;
import com.lele.apps.cms.bean.extend.PrivilegeExtend;
import com.lele.apps.cms.service.IPrivilegeService;
import com.lele.apps.cms.utils.Message;
import com.lele.apps.cms.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName PrivilegeController
 * @date 2019-11-21 15:56
 * @description 权限管理的后端控制器
 */
@Api(description = "权限管理的相关控制器接口")
@RestController
@RequestMapping("/privilege")
public class PrivilegeController {
    
    @Autowired
    private IPrivilegeService privilegeService;
    
    @ApiOperation("查询所有的权限")
    @GetMapping("findAll")
    public Message findAll(){
        List<Privilege> list = privilegeService.findAll();
        return MessageUtil.success("查询成功",list);
    }
    @ApiOperation("查询所有的权限，包括当前权限的子权限")
    @GetMapping("findAllIncludeChild")
    public Message findAllIncludeChild(){
        List<PrivilegeExtend> list = privilegeService.findAllIncludeChrild();
        return MessageUtil.success("查询成功",list);
    }
    
    @ApiOperation("添加新权限的方法")
    @PostMapping("addNewPrivilegeAndUpdatePrivilege")
    public Message addNewPrivilegeAndUpdatePrivilege(Privilege privilege){
        privilegeService.saveOrUpdate(privilege);
        
        return MessageUtil.success("添加成功");
    }
    
    @ApiOperation("删除权限")
    @GetMapping("deleteById")
    public Message deleteById(Long id){
        
        privilegeService.delete(id);
        
        return MessageUtil.success("删除成功");
    }
   

}
