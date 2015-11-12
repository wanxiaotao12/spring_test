package com.ioc.base;

import com.base.UtilDatePropertyEditor;
import com.spring.bean.Bean;
import com.spring.bean.Bean2Impl;
import com.spring.bean.Bean3Impl;
import com.spring.bean.BeanImpl;
import com.spring.bean.test.*;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA. User: wan Date: 13-7-31 Time: 下午11:17 To change
 * this template use File | Settings | File Templates.
 */
public class SpringTest {

    /**
     * 使用编码方式
     * 可以看到使用的主要类
     * DefaultListableBeanFactory、BeanDefinition、MutablePropertyValues 类及类结构
     */
    @Test
    public void testByCode() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        bindViaCaode(factory);
        Bean bean = (Bean) factory.getBean("bean");
        bean.say();
    }

    /**
     * BeanDefinitionRegistry是接口， DefaultListableBeanFactory是其实现类
     *
     * @param registry
     * @return
     */
    private BeanFactory bindViaCaode(BeanDefinitionRegistry registry) {
        AbstractBeanDefinition beanDefinition = new RootBeanDefinition(BeanImpl.class, true);
        AbstractBeanDefinition bean2Definition = new RootBeanDefinition(Bean2Impl.class, true);
        AbstractBeanDefinition bean3Definition = new RootBeanDefinition(Bean3Impl.class, true);

        registry.registerBeanDefinition("bean", beanDefinition);
        registry.registerBeanDefinition("bean2", bean2Definition);
        registry.registerBeanDefinition("bean3", bean3Definition);

        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue("age", 12);
        propertyValues.addPropertyValue("userName", "zhangsan");
        propertyValues.addPropertyValue(new PropertyValue("bean2", bean2Definition));
        propertyValues.addPropertyValue(new PropertyValue("bean3", bean3Definition));

        beanDefinition.setPropertyValues(propertyValues);

        return (BeanFactory) registry;
    }

    /**
     * 使用xml配置文件
     */
    @Test
    public void testDefaultListableBeanFactory() {
        ClassPathResource res = new ClassPathResource("simple-bean.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(res);
        SimpleBeanImpl simpleBeanImpl = (SimpleBeanImpl) factory.getBean("simpleBeanImpl");
        simpleBeanImpl.sayHi();
    }

    /**
     * XmlBeanFactory是DefaultListableBeanFactory的子类， 包装了XmlBeanDefinitionReader
     */
    @org.junit.Test
    public void testXmlBeanFactory() {
        ClassPathResource res = new ClassPathResource("beans.xml");
        XmlBeanFactory factory = new XmlBeanFactory(res);
        Bean bean = (Bean) factory.getBean("bean");
        bean.say();
    }

    /**
     * 使用ClassPathXmlApplicationContext
     */
    @org.junit.Test
    public void testContextFactory() {
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
        Bean bean = (Bean) factory.getBean("bean");
        bean.say();
    }

    @org.junit.Test
    public void test2() {
        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext(
                "E:\\Spring\\src\\main\\resource\\beans.xml");

        //        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        //        propertyPlaceholderConfigurer.setLocation(new ClassPathResource("a.property"));
        //
        //        propertyPlaceholderConfigurer.postProcessBeanFactory(factory.getBeanFactory());
        Bean bean = (Bean) factory.getBean("bean");
        bean.say();
    }

    /**
     * 依赖其他Bean
     */
    @Test
    public void testDependOtherBean() {
        ClassPathResource res = new ClassPathResource("simple-bean2.xml");

        XmlBeanFactory factory = new XmlBeanFactory(res);
        SimpleBean2 bean = (SimpleBean2) factory.getBean("simpleBean2");

        bean.test();
    }

    /**
     * 属性中的占位符， 使用propertes文件中的配置 使用BeanFactory方式
     */
    @org.junit.Test
    public void testPropertyFile() {
        ClassPathResource res = new ClassPathResource("simple-bean3.xml");
        XmlBeanFactory factory = new XmlBeanFactory(res);
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocation(new ClassPathResource("a.property"));

        propertyPlaceholderConfigurer.postProcessBeanFactory(factory);

        SimpleBean3 bean = (SimpleBean3) factory.getBean("simpleBean3");
        bean.test();
    }

    /**
     * 属性中的占位符， 使用propertes文件中的配置 使用ApplicationContext的方式
     */
    @org.junit.Test
    public void testPropertyFile2() {
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("simple-bean4.xml");
        SimpleBean3 bean = (SimpleBean3) factory.getBean("simpleBean3");
        bean.test();
    }

    @org.junit.Test
    public void testPropertyOverrideConfigurer() {
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("simple-bean4_1.xml");
        SimpleBean3 bean = (SimpleBean3) factory.getBean("simpleBean3");
        bean.test();
    }

    /**
     * 注册自定义属性转换器 使用BeanFactory方式
     */
    @Test
    public void testCustomEdit() {
        ClassPathResource res = new ClassPathResource("simple-bean5.xml");
        XmlBeanFactory factory = new XmlBeanFactory(res);

        CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
        Map map = new HashMap();
        map.put(Date.class, new UtilDatePropertyEditor());
        customEditorConfigurer.setCustomEditors(map);

        customEditorConfigurer.postProcessBeanFactory(factory);

        SimpleBean4 bean = (SimpleBean4) factory.getBean("simpleBean4");
        bean.test();
    }

    /**
     * 注册自定义属性转换器 使用ApplicationContext方式
     */
    @Test
    public void testCustomEdit2() {
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("simple-bean6.xml");

        SimpleBean4 bean = (SimpleBean4) factory.getBean("simpleBean4");
        bean.test();
    }

    /**
     * bean处理器 使用BeanFactory方式
     */
    @Test
    public void testBeanPostProcessor() {
        ClassPathResource res = new ClassPathResource("simple-bean7.xml");
        XmlBeanFactory factory = new XmlBeanFactory(res);

        CustomBeanPostProcessor beanPostProcessor = new CustomBeanPostProcessor();
        //将BeanPostProcessor工厂处理器注入到BeanFactory
        factory.addBeanPostProcessor(beanPostProcessor);

        SimpleBean5 bean = (SimpleBean5) factory.getBean("simpleBean5");
        bean.test();
    }

    /**
     * bean处理器及bean的生命周期 使用ApplicationContext方式
     */
    @Test
    public void testBeanPostProcessor2() {
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("simple-bean7.xml");

        SimpleBean5 bean = (SimpleBean5) factory.getBean("simpleBean5");
        bean.test();
    }

    /**
     * bean的生命周期
     */
    @Test
    public void testBeanLifeCycle() {
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("simple-bean6.xml");

        SimpleBean4 bean = (SimpleBean4) factory.getBean("simpleBean4");
        bean.test();
    }

}
