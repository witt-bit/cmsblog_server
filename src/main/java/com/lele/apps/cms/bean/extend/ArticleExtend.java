package com.lele.apps.cms.bean.extend;

import com.lele.apps.cms.bean.Article;
import com.lele.apps.cms.bean.Category;
import com.lele.apps.cms.bean.Comment;
import com.lele.apps.cms.bean.User;

import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName ArticleExtend
 * @date 2019-11-12 18:34
 * @description 该类不仅有了原来Article的属性和方法，还有了拓展的功能
 */


public class ArticleExtend extends Article {
    
    //使用常量来定义当前的状态
    public static final String STATUS_UNCHECK = "未审核";
    public static final String STATUS_CHECK_PASS = "审核通过";
    public static final String STATUS_CHECK_NOPASS = "审核不通过";
    
    //拓展的栏目功能
    private Category category;
    
    //拓展的查看评论功能
    private List<Comment> comments;
    
    //拓展的查看用户id的功能
    private User user;
    
    
    public Category getCategory () {
        return category;
    }
    
    public void setCategory (Category category) {
        this.category = category;
    }
    
    public List<Comment> getComments () {
        return comments;
    }
    
    public void setComments (List<Comment> comments) {
        this.comments = comments;
    }
    
    public User getUser () {
        return user;
    }
    
    public void setUser (User user) {
        this.user = user;
    }
}
