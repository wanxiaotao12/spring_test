package com.base;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wanxiaotao on 14/11/15.
 */
public class ArrayListTest {

    @Test
    /**
     * subList方法：返回ArrayList的内部类SubList， SubList存的数据并非在另外的新的内存空间，而是与原数据ArrayList共用的数据， 只是SubList有一个对象的视图
     *
     * 添加元素，则原数组也会添加元素
     *
     */
    public void test() {
        List<String> list = new ArrayList();

        list.add("value1");
        list.add("value2");
        list.add("value3");

        List list2 = list.subList(0, list.size() - 1);

        list2.add("value4");

        System.out.println("list.size=" + list.size());
        System.out.println("list2.size=" + list2.size());

        System.out.println(list.equals(list2));

    }


    @Test
    /**
     * subList 原数组添加元素， 则subList.size()数组会报错:java.util.ConcurrentModificationException
     * 原因：SubList 类的每个方法：get,size, add 等， 都会调用方法：checkForComodification
     *
     * private void checkForComodification() {
        if (ArrayList.this.modCount != this.modCount)   // 原ArrayList 的 modCount(每添加一个元素，则加1) 与subLis不相等，则抛出异常
        throw new ConcurrentModificationException();
     }
     * 结论：subList后， 原ArrayList 则不能修改其数据
     *
     * 可以将其设为只读
     *
     */
    public void test2() {
        List<String> list = new ArrayList<String>();

        list.add("value1");
        list.add("value2");
        list.add("value3");

        List<String> list2 = list.subList(0, list.size());

        //对list1设置为只读状态
        //list = Collections.unmodifiableList(list);

        //原list 添加元素，
        list.add("value4");

        System.out.println("list.size=" + list.size());

        System.out.println("list2.size=" + list2.size());

    }

    /**
     * 下面的写法， 在jdk6下有问题， 抛出异常：java.lang.IndexOutOfBoundsException，因为删除一个元素，但是list.size()并没有变， 所以会出现下标越界
     *
     * 但是， 使用Jdk7 就没有这个问题
     */
    @Test
    public void testRemoveData(){
        List<String> list = new ArrayList<String>();

        list.add("value1");
        list.add("value2");
        list.add("value3");
        list.add("value4");

        for(int i=0 ;i<list.size();i++) {
            if(i==1) {
                list.remove(i);
            }

            System.out.println("i=" + i + ", length=" + list.size());
        }

        System.out.println(JSON.toJSON(list));
    }

    @Test
    public void testRemoveData2(){
        List<String> list = new ArrayList<String>();

        list.add("value1");
        list.add("value2");
        list.add("value3");
        list.add("value4");

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String value = iterator.next();
            if("value2".equals(value)) {
                iterator.remove();
            }
        }

        System.out.println(JSON.toJSON(list));
    }




}
