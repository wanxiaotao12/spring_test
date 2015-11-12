package com.base.classpath;

import org.junit.Test;

import java.net.URL;

/**
 * Created by wanxiaotao on 9/11/15.
 */
public class ClassPathTest {

    @Test
    public void getClassPath() {
        //得到的是当前类class文件的URI目录。不包括自己！
        URL url = ClassPathTest.class.getResource("");
        //file:/Users/wanxiaotao/AliDrive/%e4%b8%aa%e4%ba%ba%e6%96%87%e4%bb%b6/01_spring/spring_project/target/test-classes/com/base/classpath/
        System.out.println(url);

        //得到的是当前的classpath的绝对URI路径
        URL url2 = ClassPathTest.class.getResource("/");
        //file:/Users/wanxiaotao/AliDrive/%e4%b8%aa%e4%ba%ba%e6%96%87%e4%bb%b6/01_spring/spring_project/target/test-classes/
        System.out.println(url2);


    }



    @Test
    public void getClassLoaderPath(){
        //当前ClassPath的绝对URI路径
        URL url = ClassPathTest.class.getClassLoader().getResource("");
        //file:/Users/wanxiaotao/AliDrive/%e4%b8%aa%e4%ba%ba%e6%96%87%e4%bb%b6/01_spring/spring_project/target/test-classes/
        System.out.println(url);


        //同样是，当前ClassPath的绝对URI路径
        url = ClassPathTest.class.getClassLoader().getSystemResource("");
        System.out.println(url);

        //同样是，当前ClassPath的绝对URI路径
        url = Thread.currentThread().getContextClassLoader ().getResource("");
        System.out.println(url);


    }



    @Test
    public void getWebPath(){
//        ServletActionContext.getServletContext().getRealPath(“/”)
    }
}
