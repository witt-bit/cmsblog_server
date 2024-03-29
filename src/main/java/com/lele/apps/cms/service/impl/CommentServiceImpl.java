package com.lele.apps.cms.service.impl;

import com.lele.apps.cms.bean.Comment;
import com.lele.apps.cms.bean.extend.CommentExtend;
import com.lele.apps.cms.bean.extend.LogsExtend;
import com.lele.apps.cms.config.RecordLog;
import com.lele.apps.cms.dao.CommentMapper;
import com.lele.apps.cms.dao.extend.CommentExtendMapper;
import com.lele.apps.cms.service.ICommentServer;
import com.lele.apps.cms.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName CommentServiceImpl
 * @date 2019-11-18 08:30
 * @description 评论管理的服务层
 */

@Service
public class CommentServiceImpl implements ICommentServer {
    
    @Resource
    private CommentMapper commentMapper;
    
    @Resource
    private CommentExtendMapper commentExtendMapper;
    
    /*
    @Override
    public List<CommentExtend> FindByArticleId (Long articleId) {
        
        List<CommentExtend> comments = commentExtendMapper.selectByArticleId(articleId);
        
        if (comments.size() == 0)
            throw new CustomerException("该文章还没有评论呢，快去评论吧");
        
        return comments;
    }
    */
    @Override
    @RecordLog({LogsExtend.LEVEL_SAVE,LogsExtend.LEVEL_MODIFY,LogsExtend.LEVEL_INFO})
    public void saveOrUpdate (Comment comment) throws CustomerException {
        //判断是更新还是保存
        if (comment.getId() == null) {
            //保存
            
            //初始化操作
            //设置评论时间
            comment.setCommentTime(new Date().getTime());
            //设置评论状态
            comment.setStatus(CommentExtend.STATUS_UNCHECK);
            
            //保存插入数据
            commentMapper.insert(comment);
            
            
        } else {
            //更新
            commentMapper.updateByPrimaryKey(comment);
        }
    }
    
    @Override
    @RecordLog({LogsExtend.LEVEL_QUERY,LogsExtend.LEVEL_INFO})
    public Comment findById (Long id) {
        
        return commentExtendMapper.selectById(id);
    }
    
    @Override
    @RecordLog({LogsExtend.LEVEL_QUERY,LogsExtend.LEVEL_INFO})
    public List<CommentExtend> findByStatus (String status) {
        
        //传入的状态为空，查找所有的评论
        if (status == null || status.isEmpty()) {
            return commentExtendMapper.selectAll();
        }
        
        
        //选择查找对应状态的评论
        return commentExtendMapper.selectByStatus(status);
    }
    
    @Override
    @RecordLog({LogsExtend.LEVEL_INFO,LogsExtend.LEVEL_DELETE})
    public void deleteById (Long id) {
        //判断评论是不是存在
        Comment comment = commentMapper.selectByPrimaryKey(id);
        if (comment == null || comment.equals(""))
            throw new CustomerException("该评论已经不存在了");
        //删除评论
        commentMapper.deleteByPrimaryKey(id);
    }
    
    /**
     * 批量删除评论
     *
     * @param ids id的数组
     */
    @Override
    @RecordLog({LogsExtend.LEVEL_INFO,LogsExtend.LEVEL_DELETE})
    public void batchDelete (Long[] ids) {
        if(ids==null||ids.length==0){
            throw new CustomerException("请选择要删除的评论");
        }
        
        for (Long id :ids){
            commentMapper.deleteByPrimaryKey(id);
        }
        
    }
}
