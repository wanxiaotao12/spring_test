package com.spring.bean.factorybean;

import com.spring.bean.factorybean.impl.ProductTypeImpl;

/**
 * 静态方法工厂
 * Created by IntelliJ IDEA.
 * User: wan
 * Date: 13-8-20
 * To change this template use File | Settings | File Templates.
 */
public class StaticFactory {
    public static ProductType getBeanInstance(String param) {
        System.out.println("param= " + param);
        return new ProductTypeImpl();
    }
}
