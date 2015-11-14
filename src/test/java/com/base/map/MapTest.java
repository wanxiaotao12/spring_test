package com.base.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wanxiaotao on 12/11/15.
 */
public class MapTest {
    @Test
    public void test(){
        Map<String,String> map = new HashMap<String, String>(20);
        map.put("key1", "value1");

        System.out.println(map);


        int a = "key1".hashCode();
        System.out.println(a);


        int a1 = a >>> 12 ;
        int a2 = a >>> 20;

        int a3 = a1 ^ a2;

        System.out.println(a1 + ", " + a2 + ", " + a3);


        System.out.println(indexFor(17,16));

    }

    static int indexFor(int h, int length) {
        return h & (length-1);
    }
}
