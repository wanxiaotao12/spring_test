package com.aop;

import com.service.HelloService;
import com.spring.bean.Bean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hongming on 2015/10/11.
 */
public class XmlAOPTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/aop_01.xml");

        HelloService helloService = (HelloService)ctx.getBean("helloService");

        String result = helloService.say("abc");

        System.out.println(result);
    }
}
