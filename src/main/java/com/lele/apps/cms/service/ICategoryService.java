package com.lele.apps.cms.service;

import com.lele.apps.cms.bean.Category;
import com.lele.apps.cms.bean.extend.CategoryExtend;
import com.lele.apps.cms.utils.CustomerException;

import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @InterfaceName ICategoryService
 * @date 2019-11-14 11:47
 * @description TODO
 */

public interface ICategoryService {
    List<Category> findAll();
    
    void saveOrUpdate(Category category)throws CustomerException;
    
    void deleteById(Long id)throws CustomerException;
    
    void batchDelete(Long[] ids)throws CustomerException;
    
    /**
     * 查询所有的栏目。包括父栏目
     * @return
     */
    List<CategoryExtend> findAllIncludeParent();
    
}
