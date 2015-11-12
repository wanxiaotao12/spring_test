/*
 * Copyright 2014 Aliyun.com All right reserved. This software is the
 * confidential and proprietary information of Aliyun.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Aliyun.com .
 */

package com.resource;

import org.springframework.core.io.ResourceLoader;

/**
 * Created by xiaotao.wxt on 2014/12/5.
 */
public class ResourceLoaderInjection {
    private ResourceLoader resourceLoader;

    public void getResource(String location) throws Exception{
        System.out.println(resourceLoader.getResource(location).getURL());
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
