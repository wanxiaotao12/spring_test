/*
 * Copyright 2015 Aliyun.com All right reserved. This software is the
 * confidential and proprietary information of Aliyun.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Aliyun.com .
 */

package com.test;

import com.spring.bean.test.SimpleBeanImpl;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * Created by xiaotao.wxt on 2015/1/1.
 */
public class ClassLoaderTest {
    @Test
    public void test() throws Exception{
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Class clazz = cl.loadClass("com.spring.bean.test.SimpleBeanImpl");
        Constructor c = clazz.getConstructor();
        SimpleBeanImpl simpleBean = (SimpleBeanImpl)c.newInstance();
        simpleBean.say();
    }
}
