package com.lele.apps.cms.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName TimeFormatUtil
 * @date 2019-11-24 10:59
 * @description 格式化时间的工具类
 */
@SuppressWarnings("all")
public class TimeFormatUtil {
    
    
    
    public static String nowTime () {
        return nowTime("");
    }
    public static String nowTime (String format) {
        
        if (format.equals("") || format.length() == 0) {
            format = "yyyy-MM-dd HH:mm:ss a";
        }
        // 格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat();
        // a为am/pm的标记
        sdf.applyPattern(format);
        // 获取当前时间
        Date date = new Date();
        
        // 已经格式化的现在时间（24小时制）
        return sdf.format(date);
    }
    
}
