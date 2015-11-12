/*
 * Copyright 2015 Aliyun.com All right reserved. This software is the
 * confidential and proprietary information of Aliyun.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Aliyun.com .
 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaotao.wxt on 2015/4/18.
 */
public class Test {
    public final String abc = "abc";

    public static void main(String[] args) {

        String[] ab = test(String.class, Arrays.asList("a","b"));

        String a = "ab"+ "cd";
        System.out.println(a);

        Long b1= 10L;
        Long b2= 10L;
        System.out.print(b1==b2);

        List<String>  list = Arrays.asList("a","b");

        list.toArray();


    }


    public static <T> T[] test(Class<T> t,List<T> list){
        T[] aa = (T[])Array.newInstance(t, list.size());

        for(int i=0;i<list.size();i++) {
            aa[i] = list.get(i);
        }

        return aa;
    }
}
