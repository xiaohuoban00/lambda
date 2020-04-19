package com.zmq.impl;

import com.zmq.MessageFormat;

/**
 * Created by IntelliJ IDEA.
 * User: zmq
 * Date: 2020/4/19
 */
public class MessageFormatImpl implements MessageFormat {
    @Override
    public String format(String message, String format) {
        System.out.println("message....");
        return message;
    }
}
