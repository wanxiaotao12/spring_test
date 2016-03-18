package com.base;

import com.spring.bean.test.SimpleBeanImpl;
import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * JavaBean类信息读取 Created by xiaotao.wxt on 2014/8/8.
 */
public class BeanProperty {
    @Test
    public void testGet() {
        try {
            Class clazz = Class.forName("com.spring.bean.test.SimpleBeanImpl");
            //            Constructor aa = clazz.getDeclaredConstructor();
            //            SimpleBeanImpl simpleBean = (SimpleBeanImpl)aa.newInstance();
            //            SimpleBeanImpl a  = new SimpleBeanImpl();
            SimpleBeanImpl simpleBeanImpl = new SimpleBeanImpl();
            //            simpleBeanImpl.setStrValue("str");
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (int i = 0; i < propertyDescriptors.length; i++) {
                System.out.println("--------------");
                PropertyDescriptor propertyDescriptor = propertyDescriptors[i];
                System.out.println("属性名：" + propertyDescriptor.getName());
                System.out.println("set方法：" + propertyDescriptor.getWriteMethod());
                Method getMethod = propertyDescriptor.getReadMethod();
                System.out.println("get方法名：" + getMethod);
                if (getMethod != null) {
                    //属性的类型
                    Class propertyClazz = getMethod.getReturnType();
                    System.out.println("属性类型：" + propertyClazz);
                    //执行get方法
                    System.out.println(propertyDescriptor.getName() + "值：" + getMethod.invoke(simpleBeanImpl));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Test
    public void testGet2() {
        try {
            Class clazz = Class.forName("com.spring.bean.test.SimpleBeanImpl");
            SimpleBeanImpl simpleBeanImpl = new SimpleBeanImpl();
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                PropertyDescriptor propertyDescriptor = propertyDescriptors[i];
                System.out.println("属性名：" + propertyDescriptor.getName());
                System.out.println("set方法：" + propertyDescriptor.getWriteMethod());
                Method getMethod = propertyDescriptor.getReadMethod();
                System.out.println("get方法名：" + getMethod);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
