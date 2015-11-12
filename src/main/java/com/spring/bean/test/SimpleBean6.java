package com.spring.bean.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

/**
 * Created by xiaotao.wxt on 2014/8/13.
 */
public class SimpleBean6 implements BeanNameAware,BeanFactoryAware {

    private String beanName;
    private BeanFactory beanFactory;

    public void test() {
        System.out.print("beanName = " + beanName+",beanFactory="+beanFactory);
    }


    @Override
    public void setBeanName(String name) {
       this.beanName = name;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
