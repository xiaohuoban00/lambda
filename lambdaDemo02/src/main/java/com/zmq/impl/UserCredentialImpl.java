package com.zmq.impl;

import com.zmq.UserCredential;

/**
 * Created by IntelliJ IDEA.
 * User: zmq
 * Date: 2020/4/19
 */
public class UserCredentialImpl implements UserCredential {
    @Override
    public String verifyUser(String username) {
        if("admin".equals(username)){
            return "系统管理员";
        }else if("manager".equals(username)){
            return "用户管理员";
        }
        return "普通用户";
    }
}
