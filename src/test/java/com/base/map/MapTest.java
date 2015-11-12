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
    }
}
