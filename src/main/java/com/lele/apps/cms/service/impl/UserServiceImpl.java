package com.lele.apps.cms.service.impl;

import com.lele.apps.cms.bean.Role;
import com.lele.apps.cms.bean.User;
import com.lele.apps.cms.bean.UserExample;
import com.lele.apps.cms.bean.UserRole;
import com.lele.apps.cms.bean.extend.RoleExtend;
import com.lele.apps.cms.bean.extend.UserExtend;
import com.lele.apps.cms.bean.vm.UserVM;
import com.lele.apps.cms.dao.UserMapper;
import com.lele.apps.cms.dao.UserRoleMapper;
import com.lele.apps.cms.dao.extend.RoleExtendMapper;
import com.lele.apps.cms.dao.extend.UserExtendMapper;
import com.lele.apps.cms.service.IUserService;
import com.lele.apps.cms.utils.CustomerException;
import com.lele.apps.cms.utils.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName UserServiceImpl
 * @date 2019-11-18 19:13
 * @description 用户service的实现类
 */
@Service
public class UserServiceImpl implements IUserService {
    
    @Resource
    private UserMapper userMapper;
    
    @Resource
    private UserExtendMapper userExtendMapper;
    
    @Resource
    private UserRoleMapper userRoleMapper;
    
    @Resource
    private RoleExtendMapper roleExtendMapper;
    
    
    /**
     * 通过id查询用户信息的方法
     *
     * @param id 用户的id
     * @return 用户的信息，包括级联查询的角色信息
     */
    @Override
    public UserExtend findById (Long id) {
        return userExtendMapper.selectById(id);
    }
    
    /**
     * 通过电话号码查询用户
     *
     * @param tel 传入电话号码
     * @return 返回用户对象，包括角色
     */
    @Override
    public UserExtend findByTel (String tel) {
        return userExtendMapper.selectByTelePhone(tel);
    }
    
    /**
     * 通过username查询用户的详细信息
     *
     * @param username 传入一个username的字符串
     * @return user对象，包括级联查询的信息
     */
    @Override
    public UserExtend findByUsername (String username) {
        
        //判断是不是为空
        if (username == null || username.isEmpty())
            throw new CustomerException("请输入合法的用户名");
        
        return userExtendMapper.selectByUsername(username);
    }
    
    /**
     * 保存和更新用户
     *
     * @param user 修改的用户的信息
     */
    @Override
    public void saveOrUpdate (User user) {
        //如果前台传了密码，就把密码加密
        String oldPassword = user.getPassword();
        if (oldPassword != null) {
            String MD5Password = MD5Util.calc(oldPassword);
            user.setPassword(MD5Password);
        }
        
        if (user.getId() != null) {
            //  更新操作
            userMapper.updateByPrimaryKey(user);
            return;
        }
        //注册时
        //先查询有没有注册过
        if (userExtendMapper.selectByTelePhone(user.getTelephone()) != null)
            throw new CustomerException("该用户已经被注册");
        
        // ，默认值初始化
        //设置注册时间
        user.setRegisterTime(new Date().getTime());
        //注册就启用账户
        user.setStatus(UserExtend.NORMAL);
        //默认用户名
        user.setUsername("用户" + System.currentTimeMillis() / 1000);
        //设置默认头像
        user.setUserFace("http://ku.90sjimg.com/element_origin_min_pic/01/55/09/5357474da89f688.jpg");
        
        /**
         * 分配默认权限
         */
        //1.插入用户的数据到数据库
        userMapper.insert(user);
        
        User newUser = userExtendMapper.selectByTelePhone(user.getTelephone());
        
        //2.查询默认角色
        Role role = roleExtendMapper.selectByName(RoleExtend.READER);
        
        //3.分配角色，插入数据
        //创建用户角色的对象
        UserRole userRole = new UserRole();
        userRole.setUserId(newUser.getId());
        userRole.setRoleId(role.getId());
        //插入用户角色的默认数据
        userRoleMapper.insert(userRole);
    }
    
    /**
     * 删除用户通过id
     *
     * @param id
     */
    @Override
    public void deleteById (Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null)
            throw new CustomerException("该用户已经被删除了");
        
        //做级联删除
        
        userMapper.deleteByPrimaryKey(id);
    }
    
    /**
     * 筛选显示用户信息，包括级联查询的信息
     *
     * @param rule 传入的规则(编辑，管理员，禁用或者启用字符串)
     * @return 用户详细信息的集合
     */
    @Override
    public List<? super UserExtend> screening (String rule) {
        //筛选条件为空，查询所有的用户
        if (rule == null || rule.isEmpty()) {
            //查询所有用户
            return userExtendMapper.findAll();
            
        } else if (rule.equals(UserExtend.NORMAL) || rule.equals(UserExtend.DISABLE)) {
            //不为空
            //查询某个状态的所有用户
            return userExtendMapper.selectByStatus(rule);
        } else if (rule.equals(RoleExtend.ADMINISTRATOR) || rule.equals(RoleExtend.EDITOR) || rule.equals(RoleExtend.READER)) {
            //查询某个角色的所有用户
            return roleExtendMapper.cascUserByName(rule);
        } else {
            throw new CustomerException("筛选条件不合法");
        }
    }
    
    /**
     * 登录的方法
     *
     * @param userVM@return user对象
     */
    @Override
    public User login (UserVM userVM) throws CustomerException{
    
        // 判空处理
        if(userVM==null||userVM.getUsername()==null||userVM.getUsername().equals(""))
            throw new CustomerException("请输入用户名");
        if(userVM.getPassword()==null||userVM.getPassword().equals(""))
            throw new CustomerException("请输入密码");
            
        // 查看用户是不是存在
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(userVM.getUsername());
        List<User> list = userMapper.selectByExample(userExample);
        if(list.size()==0)
            throw new CustomerException("该用户不存在");
    
        // 从集合中拿出user对象
        User user = list.get(0);
        
        // 判断密码是否匹配
        
        /*
        // 如果注册时加密了密码
            String p = MD5Util.calc(userVM.getPassword());
            if(!user.getPassword().equals(p))
                throw new CustomerException("密码错误");
        */
    
        if(!user.getPassword().equals(userVM.getPassword()))
            throw new CustomerException("密码错误");
        
    
        return user;
    }
}
