package com.lele.apps.cms.config;

import com.lele.apps.cms.utils.*;
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
        /**
         * 处理各个异常的返回状态码
         */
        if (exception instanceof CustomerException) {
            if (exception instanceof PermissionException)
                return MessageUtil.forbidden(exception.getMessage());
            if (exception instanceof UnAuthorizedException)
                return MessageUtil.unAuthorized(exception.getMessage());
            
            return MessageUtil.error(exception.getMessage());
        }
        return MessageUtil.error("您的操作不合法！");
    }
}
