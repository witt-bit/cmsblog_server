package com.lele.apps.cms.dao.extend;

import com.lele.apps.cms.bean.Comment;

import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @InterfaceName CommentExtendMapper
 * @date 2019-11-12 19:52
 * @description TODO
 */

public interface CommentExtendMapper {

    //查看某一篇文章下的所有的id
    List<Comment> selectByArticleId(Long artical_id);
    
    //查看某个用户所有的评论
    //List<Comment> selectByUserId(Long user_id);
    
    //通过用户id删除评论
    
    //通过文章id删除评论
}
