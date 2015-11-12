/*
 * Copyright 2015 Aliyun.com All right reserved. This software is the
 * confidential and proprietary information of Aliyun.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Aliyun.com .
 */

package com.proxy;

import com.user.UserService;
import com.user.impl.UserServiceImpl;

/**
 * Created by xiaotao.wxt on 2015/4/28.
 */
public class TestCiglib {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        UserService userService = (UserService)proxy.getProxyInstance(new UserServiceImpl());
        userService.addUser();

        System.out.println(userService.getClass().getSuperclass());
    }
}
