package com.lele.apps.cms.dao.extend;

import com.lele.apps.cms.bean.extend.ArticleExtend;

import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @InterfaceName ArticleExtendMapper
 * @date 2019-11-12 18:38
 * @description Article拓展功能的mapper映射接口
 */

public interface ArticleExtendMapper {

    List<ArticleExtend> selectAll();

    /**
     * 通过id查询文章，同时查出作者、分类，栏目等
     * @param id
     * @return
     */
    ArticleExtend selectById(Long id);

}