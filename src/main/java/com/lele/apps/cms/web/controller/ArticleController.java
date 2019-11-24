package com.lele.apps.cms.web.controller;

import com.lele.apps.cms.bean.Article;
import com.lele.apps.cms.bean.extend.ArticleExtend;
import com.lele.apps.cms.bean.extend.LogsExtend;
import com.lele.apps.cms.config.RecordLog;
import com.lele.apps.cms.service.IArticleService;
import com.lele.apps.cms.utils.Message;
import com.lele.apps.cms.utils.MessageUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName ArticleController
 * @date 2019-11-12 16:29
 * @description 前端直接调用的Controller接口，Article相关的接口
 */
@SuppressWarnings("all")

@Api(description = "Article相关接口")
@RestController
@RequestMapping("/article")
public class ArticleController {
    
    
    @Autowired
    private IArticleService articleService;
    
    @ApiOperation("查询所有文章")
    @GetMapping("findAll")
    public Message findAll () {
        List<Article> list = articleService.findAll();
        return MessageUtil.success(list);
    }
    
    @ApiOperation("级联查询所有文章(分类，作者)")
    @GetMapping("cascadeFindAll")
    public Message cascadeFindAll () {
        List<ArticleExtend> list = articleService.cascadeFindAll();
        return MessageUtil.success(list);
    }
    
    @RecordLog({LogsExtend.LEVEL_INFO,LogsExtend.LEVEL_ERROR})
    @ApiOperation("通过id查询文章")
    @GetMapping("findById")
    public Message findById (Long id) {
        ArticleExtend articleExtend = articleService.findById(id);
        
        return MessageUtil.success(articleExtend);
    }
    
    //保存和更新的前端控制器
    @ApiOperation("保存或更新")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate (
            @ApiParam("id") @RequestParam(value = "id", required = false) Long id,
            @ApiParam(value = "title", required = true) String title,
            @ApiParam(value = "content", required = true) String content,
            @ApiParam(value = "source", required = true) String source,
            @ApiParam(value = "categoryId", required = true) Long categoryId,
            @ApiParam(value = "authorId", required = true) Long authorId) {
        
        //判空处理
        if (title == null || title.isEmpty()) {
            return MessageUtil.error("请输入标题");
        }else if (categoryId==null||categoryId.equals("")) {
            return MessageUtil.error("请选择所属分类");
        }else if (content == null || content.isEmpty()) {
        //else if (content == null || content.isEmpty() || source == null || source.isEmpty()) {
            return MessageUtil.error("请输入内容");
        }
        
        //创建文章
        Article article = new Article();
        article.setId(id);
        article.setTitle(title);
        article.setContent(content);
        article.setSource(source);
        article.setCategoryId(categoryId);
        article.setAuthorId(authorId);
        
        articleService.saveOrUpdate(article);
        
        //保存或者更新成功
        if (id != null)
            return MessageUtil.success("更新成功！");
        else
            return MessageUtil.success("发布成功");
    }
    
    @ApiOperation("通过id删除文章")
    @GetMapping("deleteById")
    @ApiImplicitParams(@ApiImplicitParam(name = "id", value = "编号", required = true, paramType = "query"))
    public Message deleteById (Long id) {
        articleService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
    
}
