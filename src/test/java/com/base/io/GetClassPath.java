package com.base.io;

import org.junit.Test;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by hongming on 2015/7/23.
 */
public class GetClassPath {
    @Test
    public void getClassPath(){

        URL url = GetClassPath.class.getClassLoader().getResource("factorybean/beanfactory.xml");
        InputStream inputStream = GetClassPath.class.getClassLoader().getResourceAsStream("factorybean/beanfactory.xml");
//        StringReader reader = new StringReader();
//        reader.
        System.out.println(url.toString());
    }

}
