package com.lele.apps.cms.dao.extend;

import com.lele.apps.cms.bean.extend.LogsExtend;

import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @InterfaceName LogsExtendMapper
 * @date 2019-11-20 23:05
 * @description 日志功能拓展映射接口
 */

public interface LogsExtendMapper {
    
    List<LogsExtend> selectAll();
}
