package com.lele.apps.cms.utils;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName PermissionException
 * @date 2019-11-23 23:26
 * @description 前台访问的权限异常类
 */
public class PermissionException extends CustomerException {
    
    public PermissionException () {
        super();
    }
    
    public PermissionException (String message) {
        super(message);
    }
    
    public PermissionException (String message, Throwable cause) {
        super(message, cause);
    }
    
    public PermissionException (Throwable cause) {
        super(cause);
    }
    
    protected PermissionException (String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
