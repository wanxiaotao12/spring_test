package com.spring.bean.factorybean;

import com.spring.bean.factorybean.impl.ProductTypeImpl;

/**
 * 实例工厂方法
 * Created by IntelliJ IDEA.
 * User: wan
 * Date: 13-8-20
 * To change this template use File | Settings | File Templates.
 */
public class NoStaticFactory {

    public ProductType getBeanInstance() {
        return new ProductTypeImpl();
    }
}
