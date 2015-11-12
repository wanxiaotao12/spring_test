package com.spring.bean.test;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by hongming on 2015/8/6.
 */
@Service
public class AnnotationSimple {
    protected Logger log = Logger.getLogger(this.getClass());

    public void test() {
        log.info("******************AnnounationSimple********************");
    }
}
