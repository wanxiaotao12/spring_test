/*
 * Copyright 2015 Aliyun.com All right reserved. This software is the
 * confidential and proprietary information of Aliyun.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Aliyun.com .
 */

package com.test;

import com.spring.bean.Bean2Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaotao.wxt on 2015/2/11.
 */
public class Test {
    public static void main(String[] args) {
        try {
            List list = new ArrayList();
            Map map = new HashMap();
            for(int i = 0;i<1000000000;i++) {
                Bean2Impl bean2 = new Bean2Impl();
//                list.add(bean2);
                map.put(i, bean2);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
