package com.zmq;

/**
 * Created by IntelliJ IDEA.
 * User: zmq
 * Date: 2020/4/19
 * 用户身份认证标记接口
 */
@FunctionalInterface
public interface UserCredential {
    /**
     * 通过用户账号验证用户身份信息的接口
     * @param username 要验证的用户账号
     * @return 身份信息
     */
    String verifyUser(String username);

    default String getCredential(String username){
        if("admin".equals(username)){
            return "admin"+"系统管理员用户";
        }else if("manager".equals(username)){
            return "manager"+"用户管理员用户";
        }
        return "commons"+"普通用户";
    }

}
