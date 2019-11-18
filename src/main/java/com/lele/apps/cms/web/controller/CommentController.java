package com.lele.apps.cms.web.controller;

import com.lele.apps.cms.bean.Comment;
import com.lele.apps.cms.bean.extend.CommentExtend;
import com.lele.apps.cms.server.ICommentServer;
import com.lele.apps.cms.utils.Message;
import com.lele.apps.cms.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName CommentController
 * @date 2019-11-18 09:36
 * @description TODO
 */

@Api(description = "评论管理相关的接口")
@RestController
@RequestMapping("/comment")
public class CommentController {
    
    @Autowired
    private ICommentServer commentServer;
    
    /**
     * 通过状态查询所有的评论
     * @param status
     * @return
     */
    @ApiOperation("通过状态查找评论，为空时查找所有的评论")
    @GetMapping("findByStatus")
    public Message findByStatus(@RequestParam(value = "status",required = false) String status){
    
        List<CommentExtend> comments = commentServer.findByStatus(status);
        
        return MessageUtil.success("查询成功",comments);
    }
    
    /**
     * 保存和更新评论
     */
    @ApiOperation("保存或者更新评论")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(
            @ApiParam("id") @RequestParam(value = "id", required = false) Long userId,
            @ApiParam(value = "articleId", required = true) Long articleId,
            @ApiParam("parentId") @RequestParam(value = "id", required = false) Long parentId,
            @ApiParam(value = "content", required = true) String content
            ){
        
        //某些内容不能为空
        if(content==null||content.isEmpty())
            return MessageUtil.error("请输入评论内容");
        
        //创建文章
        Comment comment = new Comment();
        comment.setUserId(userId);
        comment.setArticleId(articleId);
        comment.setParentId(parentId);
        comment.setContent(content);
    
        commentServer.saveOrUpdate(comment);
        
        if(comment.getId()!=null){
            return MessageUtil.success("评论修改成功");
        }
        
        return MessageUtil.success("评论成功");
    }
    
    //通过id查询评论
    @ApiOperation("通过id查询评论")
    @GetMapping("findById")
    public Message findById(Long id){
        Comment comment = commentServer.findById(id);
        return MessageUtil.success("查询成功",comment);
    }
    
    //删除一条评论
    @ApiOperation("通过id删除评论")
    @GetMapping("deleteById")
    public Message deleteById(Long id){
        commentServer.deleteById(id);
        return MessageUtil.success("删除成功");
    }
    
}
