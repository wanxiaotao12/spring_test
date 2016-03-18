package com.base;

import org.junit.Test;

import javax.lang.model.type.TypeVariable;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * ��ȡ���͵�����
 * Created by xiaotao.wxt on 2014/8/12.
 */
public class Fanxing {
    /**
     * ��ȡ������Ϊ���͵�����
     */
    @Test
    public void getFanxingType() {
        try {
            Class clazz = Class.forName("com.spring.bean.test.SimpleBeanImpl");
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                System.out.println("-----------------------------------------");
                Class propertyClass = propertyDescriptor.getPropertyType();

                System.out.println("�������ͣ�" + propertyClass);
                Type type = propertyDescriptor.getReadMethod().getGenericReturnType();
                System.out.println("type:" + type);
                if (type instanceof ParameterizedType) {
                    Type[] types = ((ParameterizedType) type).getActualTypeArguments();
                    if (types != null && types.length > 0) {
                        System.out.println("���͵�����:" + types[0]);
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Test
    public void getFanxingType2() {
        try {
            Class clazz = Class.forName("com.spring.bean.test.SimpleBeanImpl");

            Field strValueField = clazz.getDeclaredField("strValue");
            Type strType = strValueField.getGenericType();
            System.out.println("strvalue type = " + strType);

            Field listField = clazz.getDeclaredField("listValue");
            Type listType = listField.getGenericType();
            System.out.println("listvalue type = " + listType);


            if (listType instanceof ParameterizedType) {
                Type[] types = ((ParameterizedType) listType).getActualTypeArguments();
                if (types != null && types.length > 0) {
                    System.out.println("���͵�����:" + types[0]);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


}


