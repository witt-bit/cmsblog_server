package com.lele.apps.cms.web.controller;

import com.lele.apps.cms.bean.extend.LogsExtend;
import com.lele.apps.cms.service.ILogsService;
import com.lele.apps.cms.utils.ExcelUtils;
import com.lele.apps.cms.utils.Message;
import com.lele.apps.cms.utils.MessageUtil;
import com.lele.apps.cms.utils.TimeFormatUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    @ApiOperation("通过id删除日志")
    @GetMapping("deleteById")
    public Message deleteById(Long id){
        logsService.deleteLog(id);
        return MessageUtil.success("删除成功");
    }
    
    @ApiOperation("批量删除日志")
    @PostMapping("batchDeleteByIds")
    public Message batchDeleteByIds(@RequestBody Long[] ids){
        logsService.batchDeleteLogs(ids);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "将日志导出为Excel",notes ="需要将地址复制到浏览器才能打开(使用浏览器打开)" )
    @GetMapping("exportExcel")
    public void exportExcel(HttpServletResponse response) throws Exception {
        // Excel文件的名字
        String excelName = "用户操作记录"+TimeFormatUtil.nowTime("yyyy-MM-dd HH:mm");
        
        // 设置表头
        String[] headList = new String[]{
                "编号","内容","操作时间","类型","用户id"
        };
        
        // 取数据的key
        String[] filedList = new String[]{
                "id","content","action_Time","type","user_id"
        };
        
        // 数据集合
        List<Map<String,Object>> dataList = new ArrayList<>();
    
        // 查询出所有的日志,
        List<LogsExtend> logs = logsService.findAll();
        
        // 将从数据库中查询出的日志保存到数据的集合中
        for(LogsExtend log :logs){
            Map<String, Object> line = new HashMap<>();
            line.put(filedList[0],log.getId());
            line.put(filedList[1],log.getContent());
            line.put(filedList[2],log.getActionTime());
            line.put(filedList[3],log.getType());
            line.put(filedList[4],log.getUser().getId());
            dataList.add(line);
        }
    
        // 调用工具类  创建一个Excel
        ExcelUtils.createExcel(response,excelName,headList,filedList,dataList);
    }
    
}

