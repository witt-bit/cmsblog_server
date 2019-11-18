package com.lele.apps.cms.server.impl;

import com.lele.apps.cms.bean.Article;
import com.lele.apps.cms.bean.ArticleExample;
import com.lele.apps.cms.bean.extend.ArticleExtend;
import com.lele.apps.cms.dao.ArticleMapper;
import com.lele.apps.cms.dao.extend.ArticleExtendMapper;
import com.lele.apps.cms.server.IArticleService;
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
 * @ClassName IArticleServiceImpl
 * @date 2019-11-12 18:23
 * @description TODO
 */

@SuppressWarnings("all")

@Service
public class ArticleServiceImpl implements IArticleService {
    
    @Resource
    private ArticleMapper articleMapper;
    
    @Resource
    private ArticleExtendMapper articleExtendMapper;
    
    @Override
    public List<Article> findAll () {
        return articleMapper.selectByExample(new ArticleExample());
    }
    
    /**
     * 能级联查出文章所有内容的方法
     *
     * @return
     */
    @Override
    public List<ArticleExtend> cascadeFindAll () {
        return articleExtendMapper.selectAll();
    }
    
    /**
     * 查出文章的所有内容，包括评论和作者
     *
     * @param id
     * @return
     */
    @Override
    public ArticleExtend findById (Long id) {
        return articleExtendMapper.selectById(id);
    }
    
    /**
     * 文章修改和发布的方法
     *
     * @param article
     * @throws CustomerException
     */
    @Override
    public void saveOrUpdate (Article article) throws CustomerException {
        
        //先判断是更新操作还是插入操作
        if (article.getId() != null) {
            //更新操作
            articleMapper.updateByPrimaryKey(article);
    
        } else {
            //判断标题不能重复
            ArticleExample articleExample = new ArticleExample();
            articleExample.createCriteria().andTitleEqualTo(article.getTitle());
            List<Article> list = articleMapper.selectByExample(articleExample);
            //能查出来，说明标题重复
            if (list.size() > 0) {
                throw new CustomerException("标题不能重复");
            }
    
            //不重复再做保存和更新的操作
            
            //初始化
            //设置当前文章的状态
            article.setStatus(ArticleExtend.STATUS_UNCHECK);
            //设置点赞数
            article.setThumbUp(0l);
            article.setThumbDown(0l);
            //设置发布时间
            article.setPublishTime(new Date().getTime());
            //设置阅读次数
            article.setReadTimes(0l);
            //没有任何问题之后插入数据
            articleMapper.insert(article);
        }

    }
    
    @Override
    public void deleteById (Long id) throws CustomerException {
        //先判断这个文章是不是不存在
        Article article = articleMapper.selectByPrimaryKey(id);
        if(article==null)
            throw new CustomerException("该文章不存在");
        //删除文章
        articleMapper.deleteByPrimaryKey(id);
    }
}
