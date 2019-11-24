package com.lele.apps.cms.bean.extend;

import com.lele.apps.cms.bean.Category;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName CategoryExtend
 * @date 2019-11-23 00:21
 * @description 栏目管理的拓展类
 */
public class CategoryExtend extends Category {
    
    private Category category;
    
    public Category getCategory () {
        return category;
    }
    
    public void setCategory (Category category) {
        this.category = category;
    }
}
