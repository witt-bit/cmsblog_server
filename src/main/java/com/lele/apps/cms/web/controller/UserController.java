package com.lele.apps.cms.web.controller;

import com.lele.apps.cms.bean.User;
import com.lele.apps.cms.bean.extend.UserExtend;
import com.lele.apps.cms.service.IUserService;
import com.lele.apps.cms.utils.Message;
import com.lele.apps.cms.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
    
    @ApiOperation("通过id查询用户信息，包括用户角色")
    @GetMapping("findById")
    public Message findById(Long id){
        UserExtend user = userService.findById(id);
        return MessageUtil.success(user);
    }
    
    @ApiOperation("通过username查询用户信息，包括用户角色")
    @PostMapping("findByUsername")
    public Message findByUsername(String username){
    
        UserExtend user = userService.findByUsername(username);
        return MessageUtil.success(user);
    }
    
    @ApiOperation("通过telephone查询用户的信息，包括用户的角色")
    @PostMapping("findByTel")
    public Message findByTel(String tel){
        UserExtend user = userService.findByTel(tel);
        return MessageUtil.success(user);
    }
    
    @ApiOperation("用户保存或者更新的方法(注册或者修改用户信息)")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(
            @ApiParam("id") @RequestParam(value = "id", required = false) Long id,
            @ApiParam("username") @RequestParam(value = "username", required = false) String username,
            @ApiParam("password") @RequestParam(value = "password",required = false) String password,
            @ApiParam("telephone") @RequestParam(value = "telephone") String telephone,
            @ApiParam("realname") @RequestParam(value = "realname",required = false) String realname,
            @ApiParam("gender") @RequestParam(value = "gender",required = false)  String gender,
            @ApiParam("birth") @RequestParam(value = "birth",required = false) Long birth,
            @ApiParam("user_face") @RequestParam(value = "user_face",required = false) String user_face
            ){
    
        //创建用户
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setTelephone(telephone);
        user.setRealname(realname);
        user.setGender(gender);
        user.setBirth(birth);
        user.setUserFace(user_face);
        
        //调用service层
        userService.saveOrUpdate(user);
        
        if(id==null)
            return MessageUtil.success("注册成功");
        
        return MessageUtil.success("更新成功");
    }
    
    @ApiOperation("通过id删除单个用户")
    @GetMapping("deleteById")
    public Message deleteById(Long id){
        userService.deleteById(id);
        return  MessageUtil.success("删除成功");
    }
    
    @ApiOperation("通过指定的规则筛选用户")
    @GetMapping("screeningUserData")
    public Message screeningUserData(String rule){
        List<? super UserExtend> users = userService.screening(rule);
    
        return MessageUtil.success("查询成功",users);
    }
    
    
}
