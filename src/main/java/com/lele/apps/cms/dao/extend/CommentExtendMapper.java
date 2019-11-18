package com.lele.apps.cms.dao.extend;

import com.lele.apps.cms.bean.Comment;
import com.lele.apps.cms.bean.extend.CommentExtend;

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

    //级联查询所有的评论
    List<CommentExtend> selectAll();
    
    //查看某一篇文章下的所有的评论
    List<CommentExtend> selectByArticleId(Long artical_id);
    
    //通过评论id级联查询评论
    Comment selectById(Long id);
    
    //通过用户id删除评论
    
    //通过状态查找评论
    List<CommentExtend> selectByStatus(String satus);
}
