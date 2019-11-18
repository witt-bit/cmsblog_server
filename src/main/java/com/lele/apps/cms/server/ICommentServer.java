package com.lele.apps.cms.server;

import com.lele.apps.cms.bean.Comment;
import com.lele.apps.cms.bean.extend.CommentExtend;
import com.lele.apps.cms.utils.CustomerException;

import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @InterfaceName ICommentServer
 * @date 2019-11-18 08:22
 * @description 评论管理的Service
 */

public interface ICommentServer {
    
    /**
     * 某篇文章的所有评论
     */
    //List<CommentExtend> FindByArticleId(Long articleId);
    
    /**
     * 评论的保存和更新
     */
    void saveOrUpdate(Comment comment)throws CustomerException;
    
    /**
     * 通过id查询某一条评论
     */
    
    Comment findById(Long id);
    
    /**
     * 查询某一个状态的所有评论
     */
    List<CommentExtend> findByStatus(String status);
    
    /**
     * 删除某一条评论
     */
    void deleteById(Long id);
}
