package com.ioc.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * Created by wanxiaotao on 8/11/15.
 */
//public class PostProcessorAdapter extends InstantiationAwareBeanPostProcessorAdapter implements InitializingBean {
public class PostProcessorAdapter extends InstantiationAwareBeanPostProcessorAdapter implements InitializingBean,BeanPostProcessor {
    public void afterPropertiesSet() throws Exception {

        System.out.println("**********PostProcessorAdapter   afterPropertiesSet ******** ");
    }


    public boolean postProcessAfterInstantiation(final Object bean, String beanName) throws BeansException {
        System.out.println("beanName=" + beanName);

        ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {

            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                ReflectionUtils.makeAccessible(field);

                System.out.println("field=" + field.getName() + ", value= " + ReflectionUtils.getField(field,bean));

                if(field.getName().equals("age")) {
                    ReflectionUtils.setField(field,bean,789);
                }
            }
        });

        return true;
    }


    @Override
    public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization beanName=" + beanName);

        ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {

            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                ReflectionUtils.makeAccessible(field);

                System.out.println("field=" + field.getName() + ", value= " + ReflectionUtils.getField(field,bean));

                if(field.getName().equals("age")) {
                    ReflectionUtils.setField(field,bean,789);
                }
            }
        });

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization   beanName=" + beanName);

        return bean;
    }
}
