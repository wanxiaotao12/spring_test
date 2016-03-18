package com.ioc.base;

import com.spring.bean.Bean2;
import com.spring.bean.test.SimpleBeanImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wanxiaotao
 * @since 2016-01-14 15:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/simple-bean.xml" })
public class JunitTest extends AbstractJUnit4SpringContextTests {
    @Autowired private SimpleBeanImpl simpleBean;

    @Test public void test() {

        simpleBean.test();
    }

}
