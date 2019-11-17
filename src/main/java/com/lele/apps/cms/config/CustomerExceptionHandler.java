package com.lele.apps.cms.config;

import com.lele.apps.cms.utils.Message;
import com.lele.apps.cms.utils.MessageUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: app01
 * @description: 统一异常处理类
 * @author: charles
 * @create: 2019-03-13 21:03
 **/
@SuppressWarnings("all")
@RestControllerAdvice
public class CustomerExceptionHandler {
    
    @ExceptionHandler(value = Exception.class)
    // 捕获 Controller 中抛出的指定类型的异常，也可以指定其他异常
    public <E> Message handler (Exception exception) {
        exception.printStackTrace();
        return MessageUtil.error(exception.getMessage());
    }
}