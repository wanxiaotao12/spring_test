package com.ioc.postprocessor;

import com.spring.bean.Bean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA. User: wan Date: 13-7-31 Time: 下午11:17 To change
 * this template use File | Settings | File Templates.
 */
public class SpringTest {



    /**
     * bean处理器及bean的生命周期 使用ApplicationContext方式
     */
    @Test
    public void testBeanPostProcessor() {
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("beanpostprocess.xml");

        Bean bean = (Bean) factory.getBean("bean");
        bean.say();
    }



}
