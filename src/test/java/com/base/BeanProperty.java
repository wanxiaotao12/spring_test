package com.base;

import com.spring.bean.test.SimpleBeanImpl;
import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * JavaBean����Ϣ��ȡ Created by xiaotao.wxt on 2014/8/8.
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
                System.out.println("��������" + propertyDescriptor.getName());
                System.out.println("set������" + propertyDescriptor.getWriteMethod());
                Method getMethod = propertyDescriptor.getReadMethod();
                System.out.println("get��������" + getMethod);
                if (getMethod != null) {
                    //���Ե�����
                    Class propertyClazz = getMethod.getReturnType();
                    System.out.println("�������ͣ�" + propertyClazz);
                    //ִ��get����
                    System.out.println(propertyDescriptor.getName() + "ֵ��" + getMethod.invoke(simpleBeanImpl));
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
                System.out.println("��������" + propertyDescriptor.getName());
                System.out.println("set������" + propertyDescriptor.getWriteMethod());
                Method getMethod = propertyDescriptor.getReadMethod();
                System.out.println("get��������" + getMethod);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
