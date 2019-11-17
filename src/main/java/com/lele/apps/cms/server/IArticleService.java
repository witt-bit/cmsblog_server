package com.lele.apps.cms.server;

import com.lele.apps.cms.bean.Article;
import com.lele.apps.cms.bean.extend.ArticleExtend;
import com.lele.apps.cms.utils.CustomerException;

import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @InterfaceName IArticleService
 * @date 2019-11-12 18:22
 * @description TODO
 */

public interface IArticleService {

    List<Article> findAll();

    List<ArticleExtend> cascadeFindAll();
    
    /**
     * 通过文章id查出文章，分类，评论等信息
     * @param id
     * @return
     */
    ArticleExtend findById(Long id);
    
    void saveOrUpdate(Article article)throws CustomerException;
    
    void deleteById(Long id)throws CustomerException;

}
