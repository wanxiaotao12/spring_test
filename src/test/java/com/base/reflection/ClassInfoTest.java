package com.base.reflection;

import com.spring.bean.Bean;
import com.spring.bean.test.SimpleBean;
import com.spring.bean.test.SimpleBeanImpl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by xiaotao.wxt on 2014/8/8.
 */
public class ClassInfoTest {

    /**
     * 通过构造方法反射， 获取对象实例
     */
    @org.junit.Test
    public void test() {
        try {
            System.out.println("我是要无可奈何");
            Constructor constructor = SimpleBeanImpl.class.getDeclaredConstructor();
            //设置构造方法可用的，以防止构造方法是private
            constructor.setAccessible(true);
            SimpleBean simpleBean = (SimpleBean) constructor.newInstance();
            simpleBean.sayHi();
        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    /**
     * 通过内省获取Class信息
     */
    @org.junit.Test
    public void testClassInfo() {
        try {
            Class clazz = Class.forName("com.spring.bean.BeanImpl");
            Bean bean = (Bean) clazz.newInstance();
            Method[] methods = clazz.getMethods();
            for (int i = 0; i < methods.length; i++) {
                System.out.println(methods[i].getName());
            }
            Constructor[] constructors = clazz.getConstructors();
            for (int i = 0; i < constructors.length; i++) {
                System.out.println(constructors[i].getName());
            }
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
//                fields[i].set(bean, "wan");
                System.out.println(fields[i].getName());
            }
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            System.out.println("--------------");
            for (int i = 0; i < propertyDescriptors.length; i++) {
                System.out.println(propertyDescriptors[i].getWriteMethod());
                System.out.println(propertyDescriptors[i].getReadMethod());

            }
            System.out.println("dd");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}


