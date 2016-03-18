package com.resource;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.Properties;

/**
 * Created by wanxiaotao on 7/11/15.
 */
public class SpringPropertyTest {
    @Test
    public void testPropertiesFactoryBean(){
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("resource/properties.xml");
        Properties properties = (Properties) factory.getBean("properties");


        for(Map.Entry entry : properties.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}
