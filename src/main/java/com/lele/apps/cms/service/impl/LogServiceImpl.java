package com.lele.apps.cms.service.impl;

import com.lele.apps.cms.bean.Logs;
import com.lele.apps.cms.bean.extend.LogsExtend;
import com.lele.apps.cms.config.RecordLog;
import com.lele.apps.cms.dao.LogsMapper;
import com.lele.apps.cms.dao.extend.LogsExtendMapper;
import com.lele.apps.cms.service.ILogsService;
import com.lele.apps.cms.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName LogServiceImpl
 * @date 2019-11-20 22:43
 * @description 日志记录的接口实现类
 */
@Service
public class LogServiceImpl implements ILogsService {
    
    @Resource
    private LogsMapper logsMapper;
    
    @Resource
    private LogsExtendMapper logsExtendMapper;
    
    /**
     * 查询所有日志记录的方法
     *
     * @return 日志记录的集合
     */
    @Override
    @RecordLog({LogsExtend.LEVEL_QUERY,LogsExtend.LEVEL_INFO})
    public List<LogsExtend> findAll () {
        return logsExtendMapper.selectAll();
    }
    
    /**
     * 批量删除日志的方法
     *
     * @param ids 批量删除的id数组
     */
    @Override
    @RecordLog({LogsExtend.LEVEL_INFO,LogsExtend.LEVEL_DELETE})
    public void batchDeleteLogs (Long[] ids) {
        
        //判断是不是传了个空
        if(ids.length==0)
            throw new CustomerException("请至少选择一项");
        
        for(Long id: ids){
    
            //先查有没有该日志记录
            Logs logs = logsMapper.selectByPrimaryKey(id);
            if(logs==null||logs.equals("")){
                throw new CustomerException("该日志记录不存在");
            }
            //有就删除
            logsMapper.deleteByPrimaryKey(id);
        }
    }
    
    /**
     * 删除日志的方法
     *
     * @param id 要删除的日志id
     */
    @Override
    @RecordLog({LogsExtend.LEVEL_INFO,LogsExtend.LEVEL_DELETE})
    public void deleteLog (Long id) {
        //先判断存不存在
        Logs logs = logsMapper.selectByPrimaryKey(id);
        if(logs==null||logs.equals(""))
            throw new CustomerException("该日志记录不存在");
        
        //存在再删除
        logsMapper.deleteByPrimaryKey(id);
    
    }
    
    /**
     * 记录日志的方法
     *
     * @throws CustomerException 记录失败的异常
     */
    @Override
    public void addLog (Logs log) throws CustomerException {
        //空对象，或者有id都不合法
        if(log==null||log.getId()!=null)
            throw new CustomerException("非法的日志记录操作");
        
        //初始化日志时间
        
        log.setActionTime(new Date().getTime());
        
        //插入数据库
        logsMapper.insert(log);
    
    }
}
