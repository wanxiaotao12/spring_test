package com.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wanxiaotao
 * @since 2016-03-15 19:25
 */
public class LogTest {

    @Test
    public void test(){
        Logger logger = LoggerFactory.getLogger(LogTest.class);

        logger.error("dddddd");
    }
}
