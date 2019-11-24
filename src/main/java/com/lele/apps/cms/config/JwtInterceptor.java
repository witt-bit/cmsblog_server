package com.lele.apps.cms.config;

import com.lele.apps.cms.bean.Privilege;
import com.lele.apps.cms.service.IPrivilegeService;
import com.lele.apps.cms.utils.JwtTokenUtil;
import com.lele.apps.cms.utils.PermissionException;
import com.lele.apps.cms.utils.UnAuthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName JwtInterceptor
 * @date 2019-11-23 22:37
 * @description token拦截器，拦截请求，做用户权限验证
 */
public class JwtInterceptor extends HandlerInterceptorAdapter {
    
    @Autowired
    private IPrivilegeService privilegeService;
    
    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果请求方式是OPTIONS  不拦截
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        
        // 获取请求头信息authorization信息
        final String token = request.getHeader(JwtTokenUtil.AUTH_HEADER_KEY);
        if(StringUtils.isEmpty(token))
            throw new UnAuthorizedException("用户未登录");
        
        // 验证token是否有效--内部验证，抛出对应异常，有效继续执行程序
        JwtTokenUtil.parseJWT(token, JwtTokenUtil.base64Secret);
    
        long id = Long.parseLong(JwtTokenUtil.getUserId(token, JwtTokenUtil.base64Secret));
        this.auth(id,request.getServletPath());
    
        return true;
    }
    
    // 判断前台请求的权限是否和对应角色的权限匹配
    private boolean auth (long userId, String path) {
    
        // 根据用户的id查询当前用户的所有权限
        List<Privilege> privileges = privilegeService.selectByUserId(userId);
        // 使用正则表达式 将每一条请求的路径和当前用户角色授权的路径做对比  看是否匹配
        for (Privilege privilege : privileges){
            if(privilege.getRoute().matches(path))
                return true;
        }
        // 没有匹配的权限，无权限访问
        throw new PermissionException("当前无权限访问");
    }
}
