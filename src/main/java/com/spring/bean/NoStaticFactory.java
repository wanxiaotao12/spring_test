package com.spring.bean;

/**
 * Created by IntelliJ IDEA.
 * User: wan
 * Date: 13-8-20
 * Time: ионГ12:30
 * To change this template use File | Settings | File Templates.
 */
public class NoStaticFactory {

    public Bean3 getBean3Instance() {
        return new Bean3Impl();
    }
}
