package com.spring.bean.factorybean;

import com.spring.bean.factorybean.impl.ProductTypeImpl;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by xiaotao.wxt on 2014/8/14.
 */
public class CustomFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        ProductType productType = new ProductTypeImpl();
        return productType;
    }

    @Override
    public Class getObjectType() {
        return ProductType.class;
    }
    @Override
    public boolean isSingleton() {
        return true;
    }
}
