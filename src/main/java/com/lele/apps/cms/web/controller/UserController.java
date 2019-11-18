package com.lele.apps.cms.web.controller;

import com.lele.apps.cms.bean.User;
import com.lele.apps.cms.bean.extend.UserExtend;
import com.lele.apps.cms.server.IUserService;
import com.lele.apps.cms.utils.Message;
import com.lele.apps.cms.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName UserController
 * @date 2019-11-18 15:23
 * @description 用户控制的接口
 */
@Api(description = "用户相关的接口")
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private IUserService userService;
    
    @ApiOperation("登录的接口")
    @PostMapping("login")
    public Message login (@RequestBody User user) {
        //验证用户身份
        // 产生一个token，缓存起来
        //返回
        Map<String, String> map = new HashMap<>();
        map.put("token", "admin-token");
        
        return MessageUtil.success(map);
        
    }
    
    @ApiOperation("退出")
    @PostMapping("logout")
    public Message logout () {
        //将缓存中的token移除
        //other
        
        return MessageUtil.success("success");
    }
    
    @ApiOperation("用户信息")
    @GetMapping("info")
    public Message info () {
        //通过token获取用户信息
        //通过id
    
        UserExtend user = userService.findById(1L);
    
        return MessageUtil.success(user);
    }
}
