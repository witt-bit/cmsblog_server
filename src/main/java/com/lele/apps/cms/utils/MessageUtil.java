package com.lele.apps.cms.utils;

import java.util.Date;

@SuppressWarnings("all")
public class MessageUtil {
    /**
     * 返回失败消息，一般用于增删改操作的结果返回
     * */
    public static Message error(String msg){
        Message message = new Message();
        message.setStatus(500);
        message.setMessage(msg);
        message.setTimestamp(new Date().getTime());
        return message;
    }

    /**
     * 返回成功消息，一般用于增删改操作的结果返回
     * */
    public static Message success(String msg){
        Message message = new Message();
        message.setStatus(200);
        message.setMessage(msg);
        message.setTimestamp(new Date().getTime());
        return message;
    }
    /**
     * 返回成功的消息，一般用于查询操作的结果返回
     * */
    public static Message success(String msg,Object data){
        Message message = new Message();
        message.setStatus(200);
        message.setMessage(msg);
        message.setData(data);
        message.setTimestamp(new Date().getTime());
        return message;
    }
    
    /**
     * 返回成功的消息，一般用于查询操作的结果返回
     * */
    public static Message success(Object data){
        Message message = new Message();
        message.setStatus(200);
        message.setMessage("success");
        message.setData(data);
        message.setTimestamp(new Date().getTime());
        return message;
    }
    
    /**
     * 权限不足的返回消息
     * @param msg
     * @return message
     */
    public static Message forbidden(String msg){
        Message message = new Message();
        message.setStatus(403);
        message.setMessage(msg);
        message.setTimestamp(new Date().getTime());
        return message;
    }
    
    /**
     * 未授权的返回消息
     * @param msg
     * @return
     */
    public static Message unAuthorized(String msg){
        Message message = new Message();
        message.setStatus(401);
        message.setMessage(msg);
        message.setTimestamp(new Date().getTime());
        return message;
    }
    
}
