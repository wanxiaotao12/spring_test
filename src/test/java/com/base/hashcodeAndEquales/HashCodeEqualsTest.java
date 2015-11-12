package com.base.hashcodeAndEquales;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wanxiaotao on 12/11/15.
 */
public class HashCodeEqualsTest {

    @Test
    public void test(){
        Person person1 = new Person("zhangsan", "11");
        Person person2 = new Person("zhangsan", "12");

        System.out.println("person1.equals(persion2) = " + person1.equals(person2));

        Person person3 = new Person("lisi", "11");
        Person person4 = new Person("lisi", "11");


        Set<Person> persons = new HashSet<Person>();

        /**
         * 问题前提：
         * 概念
         * 哈希算法也称为散列算法，是将某一数据（如内存地址）依特定算法（如取模）得到的hashcode值，
         * 将hashcode值与内存地址存在在一个数组里，像字典的目录一样，通过hashcode值可以快速找到对应的地址。
         *
         * 1、Set是存放不重复的数据
         * 2、Set集合在添加元素时， 如何判断将添加的元素与已存在的元素不重复的？如果当前有1000元素，需要比较1000次(equals方法)， 这样效率很低
         *
         *
         * 执行步骤：
         * 每一次add都会调用 person对象的hashCode方法，获取hashCode，
         * 判断hashCode对应的内存地址是否有对象，如果没有，直接添加；如果有，则将当前对象与内存中的对象equals方法比较，this: 当前对象，  obj：内存中的对象
         *
         * equals方法：如果返回true，则对象是重复，不添加；如果返回false，对象不重复，添加
         */
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);

        System.out.println("set size = " + persons.size());

    }

}
