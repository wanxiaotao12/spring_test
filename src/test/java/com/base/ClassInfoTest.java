package com.base;

import com.spring.bean.Bean;
import com.spring.bean.test.SimpleBean;
import com.spring.bean.test.SimpleBeanImpl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;

/**
 * Created by xiaotao.wxt on 2014/8/8.
 */
public class ClassInfoTest {

    /**
     * ͨ�����췽�����䣬 ��ȡ����ʵ��
     */
    @org.junit.Test
    public void test() {
        try {
            System.out.println("����Ҫ�޿��κ�");
            Constructor constructor = SimpleBeanImpl.class.getDeclaredConstructor();
            //���ù��췽�����õģ��Է�ֹ���췽����private
            constructor.setAccessible(true);
            SimpleBean simpleBean = (SimpleBean) constructor.newInstance();
            simpleBean.sayHi();
        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    /**
     * ͨ����ʡ��ȡClass��Ϣ
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


