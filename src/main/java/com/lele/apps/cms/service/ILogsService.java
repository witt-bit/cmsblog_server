package com.lele.apps.cms.service;

import com.lele.apps.cms.bean.Logs;
import com.lele.apps.cms.bean.extend.LogsExtend;
import com.lele.apps.cms.utils.CustomerException;

import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @InterfaceName ILogsService
 * @date 2019-11-20 22:32
 * @description 日志记录的Service层接口
 */

public interface ILogsService {
    
    /**
     * 查询所有日志记录的方法
     * @return 日志记录的集合
     */
    List<LogsExtend> findAll();
    
    /**
     * 批量删除日志的方法
     * @param ids 批量删除的id数组
     */
    void batchDeleteLogs(Long[] ids);
    
    /**
     * 删除日志的方法
     * @param id 要删除的日志id
     */
    void deleteLog(Long id);
    
    /**
     * 记录日志的方法
     * @throws CustomerException 记录失败的异常
     */
    void addLog(Logs log)throws CustomerException;
    
}
