package com.spring.bean.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 通过bean处理器， 可以改变bean， 如:在aop中， 可以替换成代理类
 * Created by xiaotao.wxt on 2014/8/14.
 */
public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization, beanName = " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization, beanName = " + beanName);

        return bean;
    }
}
