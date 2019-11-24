package com.lele.apps.cms.config;

import com.lele.apps.cms.bean.Logs;
import com.lele.apps.cms.bean.extend.LogsExtend;
import com.lele.apps.cms.service.ILogsService;
import com.lele.apps.cms.utils.CustomerException;
import com.lele.apps.cms.utils.IpAdrressUtil;
import com.lele.apps.cms.utils.JwtTokenUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;


/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName LogAsPect
 * @date 2019-11-24 13:26
 * @description 日志切面类
 * @Aspect 这个注解表示将当前类视为一个切面类
 * @Component 表示将当前类交由Spring管理
 */
@Aspect
@Component
public class LogAsPect {
    
    // 自动注入log的service层接口
    @Autowired
    private ILogsService logsService;
    
    // 切点表达式,定义我们的匹配规则， 匹配自定义的注解
    @Pointcut("@annotation(RecordLog)")
    public void pointCut () {
    }
    
    // @Around:环绕通知，可以在目标方法执行前后执行一些操作，以及目标方法抛出异常时执行的操作。
    @Around("pointCut()")
    public Object around (ProceedingJoinPoint point)  {
        
        Object result = null;
        
        // 方法执行开始
        long startTime = System.currentTimeMillis();
        
        // 方法执行
        try {
            result = point.proceed();
        } catch (Throwable throwable) {
            throw new CustomerException(throwable.getMessage());
        }
    
        // 方法执行结束
        long endTime = System.currentTimeMillis();
        
        // 插入数据
        insertLog(point, endTime - startTime);
        
        
        return result;
    }
    
    private void insertLog (ProceedingJoinPoint point, Long time) {
        
        // 获取增强方法（修饰符，包名，类名，方法名）
        MethodSignature signature = (MethodSignature) point.getSignature();
        
        // 得到执行的方法
        Method method = signature.getMethod();
        
        // 创建日志对象
        Logs logs = new Logs();
        
        // 拿到方法上的注解
        RecordLog annotation = method.getAnnotation(RecordLog.class);
        
        String[] value = null;
        if (annotation != null) {
            //加了这个注解，就要记录这个日志
            
            // 注解里的信息
            value = annotation.value();
        }
        
        // 请求的类名
        String className = point.getTarget().getClass().getName();
        
        // 请求的方法名
        String MethodName = signature.getName();
        
        // 方法传的参数
        String MethodArgs = Arrays.toString(point.getArgs());
        
        // 拿到用户id
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        // 请求对象
        HttpServletRequest request = requestAttributes.getRequest();
    
        String userId = null;
        String token = request.getHeader(JwtTokenUtil.AUTH_HEADER_KEY);
        if(!JwtTokenUtil.isExpiration(token,JwtTokenUtil.base64Secret)){
             userId = JwtTokenUtil.getUserId(token, JwtTokenUtil.base64Secret);
        }
        
    
    
        // session对象
        //HttpSession session = request.getSession(false);
        // 拿到用户信息
        //Long userId = (Long) session.getAttribute("userId");
        
        // 拿到ip地址
        String ipAdrress = IpAdrressUtil.getIpAdrress(request);
        
        
        // 初始化数据库日志对象
        if (value == null) {
            value = new String[]{LogsExtend.LEVEL_INFO};
        }
        logs.setType(Arrays.toString(value));
        logs.setUserId(Long.parseLong(userId));
        StringBuffer content = new StringBuffer("用户ip:{"+ipAdrress+"},类名:{");
        content.append(className);
        content.append("},方法名:{" + MethodName + "}上," + "通过参数名:{" + MethodArgs + "}");
        content.append("执行时间:{" + time + " ms}");
        logs.setContent(content.toString());
    
        logsService.addLog(logs);
    }
    
    
}
