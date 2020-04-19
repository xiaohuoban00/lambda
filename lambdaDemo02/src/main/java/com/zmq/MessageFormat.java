package com.zmq;

/**
 * Created by IntelliJ IDEA.
 * 消息传输格式化转换接口
 * User: zmq
 * Date: 2020/4/19
 */
@FunctionalInterface
public interface MessageFormat {
    /**
     * 消息转换方法
     * @param message 转换的消息
     * @param format 转换数据的格式[xml/json]
     * @return 转换后的数据
     */
    String format(String message,String format);

    static boolean verifyMessage(String message){
        if(message!=null){
            return true;
        }
        return false;
    }

}
