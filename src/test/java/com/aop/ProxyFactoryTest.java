/*
 * Copyright 2015 Aliyun.com All right reserved. This software is the
 * confidential and proprietary information of Aliyun.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Aliyun.com .
 */

package com.aop;

import com.aop.advice.CheckInterceptor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

import com.user.UserService;
import com.user.impl.UserServiceImpl;

/**
 * Created by xiaotao.wxt on 2015/5/23.
 */
public class ProxyFactoryTest {
	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();

		NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
		advisor.setMappedName("addUser");
		advisor.setAdvice(new CheckInterceptor());


		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(userService);
//		proxyFactory.setInterfaces(new Class[]{UserService.class});


		//设置advisor
		proxyFactory.addAdvisor(advisor);

		//获取代理类
		UserService userServiceProxy = (UserService)proxyFactory.getProxy();
		userServiceProxy.addUser();

	}
}
