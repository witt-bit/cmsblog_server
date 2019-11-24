package com.lele.apps.cms.bean.extend;

import com.lele.apps.cms.bean.Logs;
import com.lele.apps.cms.bean.User;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName LogsExtend
 * @date 2019-11-20 22:45
 * @description 日志功能拓展类
 */
public class LogsExtend extends Logs {
    
    //日志的类型
    //一般操作信息
    public static final String LEVEL_INFO = "info";
    //查询数据库
    public static final String LEVEL_QUERY = "query";
    //保存数据
    public static final String LEVEL_SAVE = "save";
    //错误记录
    public static final String LEVEL_ERROR = "error";
    //修改记录
    public static final String LEVEL_MODIFY = "modify";
    // 删除记录
    public static final String LEVEL_DELETE = "delete";
    
    private User user;
    
    public User getUser () {
        return user;
    }
    
    public void setUser (User user) {
        this.user = user;
    }
}
