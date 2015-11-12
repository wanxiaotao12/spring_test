package com.spring.bean.factorybean.impl;

import com.spring.bean.factorybean.Product;
import com.spring.bean.factorybean.ProductType;

/**
 * Created by xiaotao.wxt on 2014/8/14.
 */
public class ProductImpl implements Product{
    private ProductType productType;
    @Override
    public void getProduct() {
        //调用接口的方法
        productType.getProductType("1234");
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
