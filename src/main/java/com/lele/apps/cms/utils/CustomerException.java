package com.lele.apps.cms.utils;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName CustomerException
 * @date 2019-11-13 10:06
 * @description 自定义异常
 */
@SuppressWarnings("all")
public class CustomerException extends RuntimeException{
    public CustomerException () {
        super();
    }
    
    public CustomerException (String message) {
        super(message);
    }
    
    public CustomerException (String message, Throwable cause) {
        super(message, cause);
    }
    
    public CustomerException (Throwable cause) {
        super(cause);
    }
    
    protected CustomerException (String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
