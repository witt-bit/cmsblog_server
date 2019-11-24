package com.lele.apps.cms.service.impl;

import com.lele.apps.cms.bean.Category;
import com.lele.apps.cms.bean.CategoryExample;
import com.lele.apps.cms.bean.extend.CategoryExtend;
import com.lele.apps.cms.dao.CategoryMapper;
import com.lele.apps.cms.dao.extend.CategoryExtendMapper;
import com.lele.apps.cms.service.ICategoryService;
import com.lele.apps.cms.utils.CustomerException;
import com.lele.apps.cms.utils.MessageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName CategoryServiceImpl
 * @date 2019-11-14 11:49
 * @description TODO
 */
@Service
public class CategoryServiceImpl implements ICategoryService {
    
    @Resource
    private CategoryMapper categoryMapper;
    
    @Resource
    private CategoryExtendMapper categoryExtendMapper;
    
    
    @Override
    public List<Category> findAll () {
        return categoryMapper.selectByExample(new CategoryExample());
    }
    
    @Override
    public void saveOrUpdate (Category category) throws CustomerException {
        //判空处理
        if (category.getName() == null || category.getName().equals("")) {
            throw new CustomerException("栏目名称不能为空");
        }
        //判断是插入还是更新
        if (category.getId() != null) {
            //保存操作
            categoryMapper.updateByPrimaryKey(category);
            return;
        }
        
        
        //判断栏目名称是不是和已有的重复
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andNameEqualTo(category.getName());
        List<Category> list = categoryMapper.selectByExample(categoryExample);
        if (list.size() > 0)
            throw new CustomerException("栏目已经存在");
        
        //    插入操作
        categoryMapper.insert(category);
        
        
    }
    
    @Override
    public void deleteById (Long id) throws CustomerException {
        
        Category category = categoryMapper.selectByPrimaryKey(id);
        if (category == null)
            throw new CustomerException("该栏目不存在");
        
        categoryMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public void batchDelete (Long[] ids) throws CustomerException {
        if (ids.length == 0) {
            throw new CustomerException("请选择要删除的栏目");
        }
        
        for (Long id : ids) {
            categoryMapper.deleteByPrimaryKey(id);
        }
    }
    
    /**
     * 查询所有的栏目。包括父栏目
     *
     * @return
     */
    @Override
    public List<CategoryExtend> findAllIncludeParent () {
        return categoryExtendMapper.selectAllIncludeParent();
    }
}

