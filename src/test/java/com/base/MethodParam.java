package com.base;

import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * Created by xiaotao.wxt on 2014/8/12.
 */
public class MethodParam {

    @Test
    public void getMethodParams() throws Exception{
        Class clazz = Class.forName("com.spring.bean.test.SimpleBeanImpl");
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for(PropertyDescriptor descriptor : propertyDescriptors) {
            Method writeMethod = descriptor.getWriteMethod();
            if(writeMethod!=null && writeMethod.getName().startsWith("set")) {
                System.out.println("--------------------------------------");
                System.out.println("methodName = " + writeMethod.getName() + "， 参数：");
                Type[] types = writeMethod.getGenericParameterTypes();
                for(Type type : types) {
                    System.out.println(type);
                }
            }
        }
    }
}
