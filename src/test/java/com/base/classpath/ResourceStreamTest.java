package com.base.classpath;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by wanxiaotao on 10/11/15.
 */
public class ResourceStreamTest {

    /**
     * ResourceStreamTest.class.getResourceAsStream("name") 会在com.test.mycode包下查找相应的资源。
     * 如果这个name是以 '/' 开头的，那么就会从classpath的根路径下开始查找
     * @throws Exception
     */
    @Test
    public void testClassSteam() throws Exception {
        InputStream inputStream = ResourceStreamTest.class.getResourceAsStream("/test.txt");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        line = bufferedReader.readLine();
        while (line != null) {
            System.out.println(line);
            line = bufferedReader.readLine(); // 一次读入一行数据
        }
    }


    /**
     * ClassLoader.getResourceAsStream()  无论要查找的资源前面是否带'/' 都会从classpath的根路径下查找
     * @throws Exception
     */
    @Test
    public void testClassLoaderSteam() throws Exception {
        InputStream inputStream = ResourceStreamTest.class.getClassLoader().getResourceAsStream("test.txt");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        line = bufferedReader.readLine();
        while (line != null) {
            System.out.println(line);
            line = bufferedReader.readLine(); // 一次读入一行数据
        }
    }
}
