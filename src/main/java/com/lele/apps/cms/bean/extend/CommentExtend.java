package com.lele.apps.cms.bean.extend;

import com.lele.apps.cms.bean.Comment;
import com.lele.apps.cms.bean.User;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName CommentExtend
 * @date 2019-11-18 08:50
 * @description 评论的附加功能
 */
public class CommentExtend extends Comment {
    
    //常量设置状态
    public static final String STATUS_UNCHECK = "未审核";
    public static final String STATUS_CHECK_PASS = "审核通过";
    public static final String STATUS_CHECK_NOPASS = "审核未通过";
    
    //评论的作者
    private User user;
    
    public User getUser () {
        return user;
    }
    
    public void setUser (User user) {
        this.user = user;
    }
}
