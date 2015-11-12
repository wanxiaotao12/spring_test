package com.http;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;


/**
 * Created by wanxiaotao on 3/11/15.
 */
public class HttpTest {
    public static void main(String[] args) throws Exception {
        HttpClient client = new HttpClient();
        //设置代理服务器地址和端口
        //client.getHostConfiguration().setProxy("proxy_host_addr",proxy_port);
        //使用GET方法，如果服务器需要通过HTTPS连接，那只需要将下面URL中的http换成https
//        HttpMethod method = new GetMethod("http://java.sun.com");
        HttpMethod method = new GetMethod("http://dengwu-oss1.oss-us-west-1.aliyuncs.com/wan_test/test.txt");
        //使用POST方法
        //HttpMethod method = new PostMethod("http://java.sun.com";);


        for(int i = 0; i<10000 ; i++) {
            System.out.println(i);
            client.executeMethod(method);
            //打印服务器返回的状态
            System.out.println(method.getStatusLine());
            //打印返回的信息
            System.out.println(method.getResponseBodyAsString());

            //释放连接
            method.releaseConnection();

            Thread.sleep(8);
        }



    }
}
