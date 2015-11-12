package com.service.impl;

import com.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by hongming on 2015/10/11.
 */
public class HelloServiceImpl implements HelloService {
    private static Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String say(String param) {
        System.out.println("param=" + param);

        logger.info("HelloServiceImpl  *********************");
        return param;
    }
}
