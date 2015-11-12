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
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 将生成的代理类存到文件中
 * Created by xiaotao.wxt on 2015/4/28.
 */
public class ProxyClassFile {
    public static void main(String[] args) {

        String proxyName = "UserServiceProxy";

        UserService t = new UserServiceImpl();

        Class[] interfaces = t.getClass().getInterfaces();

        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(proxyName, interfaces);

        File f = new File("d:/UserServiceProxy.class");

        try {

            FileOutputStream fos = new FileOutputStream(f);

            fos.write(proxyClassFile);

            fos.flush();

            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
