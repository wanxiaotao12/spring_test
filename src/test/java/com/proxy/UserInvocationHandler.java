/*
 * Copyright 2015 Aliyun.com All right reserved. This software is the
 * confidential and proprietary information of Aliyun.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Aliyun.com .
 */

package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by xiaotao.wxt on 2015/4/28.
 */
public class UserInvocationHandler implements InvocationHandler {
    private Object target;

    public Object getProxyInstance(Object target){
        this.target = target;
        /**
         * 使用Proxy生成代理类
         * 需要的参数：
         *  类加载器
         *  目标类的接口
         *   InvocationHandler接口的实现类，即当前类的对象
         */

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object result = null;
        System.out.println("before target method...");
        result = method.invoke(target, args);
        System.out.println("after target method...");
        return result;
    }
}
