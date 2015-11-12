/*
 * Copyright 2015 Aliyun.com All right reserved. This software is the
 * confidential and proprietary information of Aliyun.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Aliyun.com .
 */

package com.spring.bean.factorybean.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.bean.factorybean.ProductType;

/**
 * Created by xiaotao.wxt on 2015/3/9.
 */
public class ProductImpl2 {
    @Autowired
    private ProductType productType;

    public void test() {
        productType.getProductType("22222");
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
