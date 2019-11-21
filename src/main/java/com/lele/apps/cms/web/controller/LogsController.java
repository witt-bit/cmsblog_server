package com.lele.apps.cms.web.controller;

import com.lele.apps.cms.bean.extend.LogsExtend;
import com.lele.apps.cms.service.ILogsService;
import com.lele.apps.cms.utils.Message;
import com.lele.apps.cms.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName LogsController
 * @date 2019-11-20 22:30
 * @description 日志记录控制器
 */
@Api(description = "日志相关的接口")
@RestController
@RequestMapping("/logs")
public class LogsController {
    
    @Autowired
    private ILogsService logsService;
    
    @ApiOperation("查询所有的日志")
    @GetMapping("findAll")
    public Message findAll(){
        List<LogsExtend> list = logsService.findAll();
        
        return MessageUtil.success("查询成功",list);
        
    }
    
    @ApiOperation("查询所有的日志")
    @GetMapping("screening")
    public Message screening(String rule){
        return MessageUtil.success("查询成功");
    }

}

