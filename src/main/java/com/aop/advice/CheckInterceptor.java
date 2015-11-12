/*
 * Copyright 2015 Aliyun.com All right reserved. This software is the
 * confidential and proprietary information of Aliyun.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Aliyun.com .
 */

package com.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by xiaotao.wxt on 2015/5/23.
 */
public class CheckInterceptor implements MethodInterceptor{
	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		System.out.println("-------begin---------");
		Object obj = methodInvocation.proceed();
		System.out.println("-------end---------");
        return obj;
	}
}
