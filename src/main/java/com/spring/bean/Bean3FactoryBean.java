package com.spring.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by IntelliJ IDEA.
 * User: wan
 * Date: 13-8-20
 * Time: ÉÏÎç12:39
 * To change this template use File | Settings | File Templates.
 */
public class Bean3FactoryBean implements FactoryBean{
    @Override
    public Object getObject() throws Exception {
        return new Bean3Impl();
    }

    @Override
    public Class getObjectType() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isSingleton() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
