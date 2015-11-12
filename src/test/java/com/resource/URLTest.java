/*
 * Copyright 2014 Aliyun.com All right reserved. This software is the
 * confidential and proprietary information of Aliyun.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Aliyun.com .
 */

package com.resource;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

/**
 * Created by xiaotao.wxt on 2014/12/27.
 */
public class URLTest {

    @Test
    public void test() throws  Exception{
        String host = "www.java2s.com";
        String file = "/index.html";

        String[] schemes = {"http", "https", "ftp", "mailto", "telnet", "file", "ldap", "gopher",
                "jdbc", "rmi", "jndi", "jar", "doc", "netdoc", "nfs", "verbatim", "finger", "daytime",
                "systemresource"};

        for (int i = 0; i < schemes.length; i++) {
            try {
                URL u = new URL(schemes[i], host, file);
                System.out.println(schemes[i] + " is supported/r/n");
            } catch (Exception ex) {
                System.out.println(schemes[i] + " is not supported/r/n");
            }
        }

        URL u = new URL("file:d:/1.txt");
        readURL(u);

    }


    private static  void readURL(URL url) throws IOException {
        //打开到此 URL 的连接并返回一个用于从该连接读入的 InputStream。
        Reader reader = new InputStreamReader(new BufferedInputStream(url.openStream()));
        int c;
        while ((c = reader.read()) != -1) {
            System.out.print((char) c);
        }
        reader.close();
    }



}
