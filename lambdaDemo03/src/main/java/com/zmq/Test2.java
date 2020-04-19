package com.zmq;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: zmq
 * Date: 2020/4/19
 */
public class Test2 {
    public static void main(String[] args) {
        //1.添加测试数据：存储多个数据的列表
        List<String> accountList = new ArrayList<>();
        accountList.add("tom");
        accountList.add("xiaobai");
        accountList.add("xiaohei");
        accountList.add("xiaohuang");
        accountList.add("damu");
        // 1.1. 业务要求：长度大于等于5的有效账号
        for (String account : accountList) {
            if (account.length() >= 5) {
                System.out.println("有效账号："  + account);
            }
        }
        // 1.2. 迭代方式进行操作
        Iterator<String> it = accountList.iterator();
        while(it.hasNext()) {
            String account = it.next();
            if (account.length() >= 5) {
                System.out.println("it有效账号：" + account);
            }
        }
        // 1.3. Stream结合lambda表达式，完成业务处理
        List<String> validAccounts = accountList.stream().filter(account -> account.length() >= 5).collect(Collectors.toList());
        System.out.println(validAccounts);
    }
}
