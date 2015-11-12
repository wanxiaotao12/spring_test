package com.spring.bean.factorybean.impl;

import com.spring.bean.factorybean.ProductType;

/**
 * Created by xiaotao.wxt on 2014/8/14.
 */
public class ProductTypeImpl implements ProductType {
    @Override
    public void getProductType(String productName) {
        System.out.println("ProductTypeImpl.getProductType");
    }
}
