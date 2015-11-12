package com.base;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaotao.wxt on 2014/8/13.
 */
public class isAssignableTest {

    /**
     *instanceof 第二参数可以类， 也可以接口， 如果是继承的接口， 同样也返回true
     */
    @Test
    public void testInstanceOf(){
        List list = new ArrayList();

        System.out.println(list instanceof  ArrayList); //true
        System.out.print(list instanceof  List);//true
    }

    /**
     * isAssignableFrom是Class的方法， 方法的参数也是Class
     * 如果Class与参数相同，则ture
     * 如果Class是参数的父类，或实现的接口， 则true
     */
    @Test
    public void testsAssignableFrom(){
       System.out.println(ArrayList.class.isAssignableFrom(ArrayList.class));//true
       System.out.println(ArrayList.class.isAssignableFrom(List.class));//false
       System.out.println(List.class.isAssignableFrom(ArrayList.class));//false
       System.out.println(AbstractList.class.isAssignableFrom(ArrayList.class));//false
    }
}
