package com.base.hashcodeAndEquales;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * hashCode 与 equals 两者方法的区别
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
         * 1、HashSet是存放不重复的数据
         * 2、假设：HashSet集合在添加元素时， 如何判断将添加的元素与已存在的元素不重复的？如果当前有1000元素，需要比较1000次(equals方法)， 这样效率很低
         *
         * HashSet：实际是采用HashMap保存数据， key 存放数据，value: 静态Oject对象，    private static final Object PRESENT = new Object();
         *
         * 所以HashSet的add方法 调用的是 HashMap的add 方法
         *
         * HashMap 的大致执行步骤：
         * 1、取key的hashCode ， 经过hash算法，获取在数组中的位置
         * 2、判断对应数组是否为空， 如果为null, 则直接存放，
         *
         * 3、如果不为null, 则说明hash冲突， 依次与当前数组位置的链表中的key是否相等(equals), 如果equals，则将新value值替换旧值
         * 不equals，则在数组位置存放新<key,value> 的指针， 新<key, value> Entry 指向原来的链表表头
         *
         *
         */
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);

        System.out.println("set size = " + persons.size());

    }

}
