package com.lele.apps.cms.dao.extend;

import com.lele.apps.cms.bean.extend.CategoryExtend;

import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @InterfaceName CategoryExtendMapper
 * @date 2019-11-23 00:24
 * @description 栏目的mapper映射接口
 */

public interface CategoryExtendMapper {
    
    List<CategoryExtend> selectAllIncludeParent ();
    
}
