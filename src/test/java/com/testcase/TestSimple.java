package com.testcase;

import com.spring.bean.test.AnnotationSimple;
import com.spring.bean.test.SimpleBean2;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hongming on 2015/8/6.
 */
public class TestSimple extends BaseTest {

    private SimpleBean2 simpleBean2;

    @Autowired
    private AnnotationSimple annotationSimple;

    @Test
    public void test(){
        simpleBean2 = (SimpleBean2)appContext.getBean("simpleBean2");
        simpleBean2.test();
    }

    @Test
    public void test2(){
        //使用getter, setter方法
        simpleBean2.test();
    }

    @Test
    public void testAnnotation(){
        annotationSimple.test();
    }

    public SimpleBean2 getSimpleBean2() {
        return simpleBean2;
    }

    public void setSimpleBean2(SimpleBean2 simpleBean2) {
        this.simpleBean2 = simpleBean2;
    }
}
