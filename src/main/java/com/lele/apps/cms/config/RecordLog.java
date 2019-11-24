package com.lele.apps.cms.config;

import java.lang.annotation.*;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @interface RecordLog
 * @date 2019-11-24 13:21
 * @description 定义一个方法级别的log注解
 * @Target({ElementType.TYPE,ElementType.METHOD}) 在类和方法上使用
 * @Retention(RetentionPolicy.RUNTIME) 在运行时生效
 * @Documented 生成doc文档注释
 */

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RecordLog {
    String[] value() default "";
}
