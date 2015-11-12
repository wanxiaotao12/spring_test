package com.spring.bean.test;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by xiaotao.wxt on 2014/8/13.
 */
public class SimpleBean5 implements InitializingBean {


    public void test() {
        System.out.print("SimpleBean5.test()");
    }

    public void init(){
        System.out.println("--------------init method----------------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("----------afterPropertiesSet------------------");
    }
}
