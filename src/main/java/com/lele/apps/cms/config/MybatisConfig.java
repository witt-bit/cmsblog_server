package com.lele.apps.cms.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.lele.apps.cms.dao")
public class MybatisConfig {

}
