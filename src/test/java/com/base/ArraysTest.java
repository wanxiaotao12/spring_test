package com.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wanxiaotao on 13/11/15.
 */
public class ArraysTest {

        /**
         * 在使用asList时不要将基本数据类型当做参数
         *
         * 基本数据类型是无法发型化的，也就是说8个基本类型是无法作为asList的参数的
         *
         * 结论：不要使用基本数据类型的数据， 作Arrays.asList()的参数
         */
        @Test
        public void test() {

            int[] ints = new int[]{1, 2, 3};

            List list = Arrays.asList(ints);

            System.out.println("size=" + list.size());
            for (Object i : list) {
                System.out.println(i);
            }

            Integer[] integers = new Integer[]{1, 2, 3};
            List list2 = Arrays.asList(integers);
            System.out.println("list2.size=" + list2.size());


        }


    @Test
    /**
     * 数组转化为 List, 但是list.add方法会抛出java.lang.UnsupportedOperationException 异常
     * 因为Arrays.asList() 返回的ArrayList， 并不是我们经常使用的java.util.ArrayList, 而是Arrays的内部类，
     *
     * private static class ArrayList<E> extends AbstractList<E>
     * implements RandomAccess, java.io.Serializable
     *
     * 内部类ArrayList 没有add方法， 则使用其父类的add方法， 父类的方法是抛出异常的
     *
     * 结论：
     * 1、Arrays.asList() 返回的数据不是java.util.ArrayList
     * 2、Arrays.asList() 返回的数据不能添加元素
     */
    public void test2(){
        Integer[] integers = new Integer[]{1, 2, 3};
        List list2 = Arrays.asList(integers);

        list2.add(4);
    }

}
