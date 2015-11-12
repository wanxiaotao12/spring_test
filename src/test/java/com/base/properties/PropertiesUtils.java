package com.base.properties;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by hongming on 2015/8/3.
 */
public class PropertiesUtils {
    protected static final Logger logger             = Logger.getLogger(PropertiesUtils.class);

    private static Map<String,String> map = new HashMap<String, String>();

    private static String[] resources = new String[]{"config/product_config.properties"};
    static {
        try {
            Properties properties = new Properties();
            for(String resource :resources) {
                InputStream stream = PropertiesUtils.class.getClassLoader().getResourceAsStream(resource);
                //根据资源文件的编码方式
                properties.load(new InputStreamReader(stream, "gbk"));

                Set keySet  = properties.keySet();
                if(CollectionUtils.isNotEmpty(keySet)) {
                    for(Object key :keySet) {
                        String value = (String)properties.get((String)key);
                        map.put((String)key,value);
                    }
                }
            }


        } catch (Exception ex) {
            logger.error("get properties value error", ex);
        }
    }

    public static String getValue(String key) {
        return map.get(key);
    }


    public static void main(String[] args) {

        String value = getValue("user.name");

        System.out.println("value=" + value);

    }

}
