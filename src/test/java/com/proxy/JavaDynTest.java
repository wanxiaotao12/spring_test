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
public class JavaDynTest {

    public static void main(String[] args){
        UserInvocationHandler handler = new UserInvocationHandler();

        UserService userService = (UserService)handler.getProxyInstance(new UserServiceImpl());
        userService.addUser();


    }
}
