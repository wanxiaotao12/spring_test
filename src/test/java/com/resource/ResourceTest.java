package com.resource;

import com.resource.ResourceInjection;
import com.resource.ResourceInjection2;
import com.resource.ResourceLoaderInjection2;
import com.resource.ResourceLoaderInjection3;
import com.spring.bean.test.SimpleBeanImpl;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.*;
import java.net.URL;
import java.util.Enumeration;

/**
 * Resource与ResourceLoader
 * 不同的Resource都会有各自的getInputStream()， 获取输入流， 读取文件内容
 * Created by xiaotao.wxt on 2014/8/15.
 */
public class ResourceTest {

    private Logger logger = LoggerFactory.getLogger(ResourceTest.class);

    /**
     * DefaultResourceLoader
     */
    @Test
    public void testDefaultResourceLoader() throws Exception {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource r1 = resourceLoader.getResource("d:/");
        Assert.assertTrue(r1 instanceof ClassPathResource);
//                Assert.assertTrue(r1.exists());

        Resource r2 = resourceLoader.getResource("file:d:/");
        Assert.assertTrue(r2 instanceof UrlResource);
        Assert.assertTrue(r2.exists());

        Resource r3 = resourceLoader.getResource("http://www.baidu.com");
        Assert.assertTrue(r3 instanceof UrlResource);
        Assert.assertTrue(r2.exists());

        Resource r4 = resourceLoader.getResource("classpath:1.txt");
        Assert.assertTrue(r4 instanceof ClassPathResource);
        Assert.assertTrue(r4.exists());

        logger.info(r4.getFilename());

        File file = r4.getFile();

        Reader reader = new InputStreamReader(new BufferedInputStream(new FileInputStream(file)));

        int c;
        while ((c = reader.read()) != -1) {
            System.out.print((char) c);
        }
        reader.close();
    }

    /**
     * FileSystemResourceLoader 继承DefaultResourceLoader, 重写getResourceByPath()方法
     */
    @Test
    public void testFileSystemResourceLoader() {
        ResourceLoader resourceLoader = new FileSystemResourceLoader();
        Resource fileResource = resourceLoader.getResource("d:/1.txt");

        Assert.assertTrue(fileResource instanceof FileSystemResource);
        Assert.assertTrue(fileResource.exists());

        Resource fileResource2 = resourceLoader.getResource("file:d:/1.txt");
        Assert.assertTrue(fileResource2 instanceof UrlResource);
        Assert.assertTrue(fileResource2.exists());
    }

    /**
     * 加载多个资源, classPath下的， 还有依赖的包中的
     * classpath*:前缀
     * 支持ant正则风格，
     *
     * @throws Exception
     */
    @Test
    public void testPathMatchingResourcePatternResolver01() throws Exception {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resource1 = resolver.getResources("classpath*:workorder-shared-message.properties");
        for (Resource resource : resource1) {
            System.out.println(resource.getFilename() + ":" + resource.exists());
        }

        //  依赖包， 写法一：classpath*:**/*PatternResolver.class 加载不到， 写法二：classpath*:org/**/*PatternResolver.class 可以加载

        /**
         * 源代码执行过程：
         * Resource[] rootDirResources = getResources(rootDirPath) //rootDirPath =classpath*:    先加载classpath*:
         * 再次调用 getResources(), 执行第二分支，
         * 调用return findAllClassPathResources(locationPattern.substring(CLASSPATH_ALL_URL_PREFIX.length()));  //方法后的参数 substring方法后， 则变为""
         *
         * 导致findAllClassPathResources()方法中： Enumeration resourceUrls = getClassLoader().getResources(path)  //path为空
         * getClassLoader().getResources(path)：从classLoader中获取资源
         *
         * 参见：http://blog.csdn.net/applebomb/article/details/7430325
         */

        Resource[] resource2 = resolver.getResources("classpath*:org/**/*PatternResolver.class");

        for (Resource resource : resource2) {
            System.out.println(resource.getURL() + ":" + resource.exists());
        }

        /**
         * src、test包下的类可以加载到
         */
        Resource[] resource3 = resolver.getResources("classpath*:**/*SimpleBean.class");

        for (Resource resource : resource3) {
            System.out.println(resource.getURL() + ":" + resource.exists());
        }


    }

    /**
     * 显示加载的jar包
     *
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
//        Enumeration resourceUrls = this.getClass().getClassLoader().getResources("1.txt");
        Enumeration resourceUrls = this.getClass().getClassLoader().getResources("org");
        while (resourceUrls.hasMoreElements()) {
            URL url = (URL) resourceUrls.nextElement();
            System.out.println(url);
        }

    }

    /**
     * PathMatchingResourcePatternResolver 默认使用DefaultResourceLoader, 可以指定使用的ResourceLoader
     *
     * @throws Exception
     */
    @Test
    public void testPathMatchingResourcePatternResolver02() throws Exception {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resource1 = resolver.getResources("classpath*:workorder-shared-message.properties");
        //        Assert.assertTrue(resource1.exists());

        Resource resource2 = resolver.getResource("d:/1.txt");
        Assert.assertTrue(resource2 instanceof ClassPathResource);
        //        Assert.assertTrue(fileResource.exists());

        //使用FileSystemResourceLoader
        resolver = new PathMatchingResourcePatternResolver(new FileSystemResourceLoader());

        resource2 = resolver.getResource("d:/1.txt");
        Assert.assertTrue(resource2 instanceof FileSystemResource);
        Assert.assertTrue(resource2.exists());

    }

    /**
     * 将ApplicationContext当ResourceLoader使用
     */
    @Test
    public void testApplicationContext() throws Exception {
        ResourceLoader resLoader = new ClassPathXmlApplicationContext();

        Resource resource = resLoader.getResource("simple-bean.xml");
        Assert.assertTrue(resource instanceof ClassPathResource);
        Assert.assertTrue(resource.exists());

        Resource[] resource2 = ((ApplicationContext) resLoader).getResources("classpath*:org/**/*PatternResolver.class");

        for (Resource res : resource2) {
            System.out.println(res.getURL() + ":" + res.exists());
        }
    }

    /**
     * ResourceLoader的注入
     *
     * @throws Exception
     */
    @Test
    public void testResourceLoaderInjectionTest() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("ResourceLoaderInjection.xml");
//        ResourceLoaderInjection injection = (ResourceLoaderInjection)context.getBean("resourceLoaderInjection");
//        injection.getResource("ResourceLoaderInjection.xml");

        ResourceLoaderInjection2 injection2 = (ResourceLoaderInjection2) context.getBean("resourceLoaderInjection2");
        injection2.getResource("ResourceLoaderInjection.xml");

        ResourceLoaderInjection3 injection3 = (ResourceLoaderInjection3) context.getBean("resourceLoaderInjection3");
        injection3.getResource("ResourceLoaderInjection.xml");

        ResourceInjection resourceInjection = (ResourceInjection) context.getBean("resourceInjection");
        resourceInjection.getResource();
//
        ResourceInjection2 resourceInjection2 = (ResourceInjection2) context.getBean("resourceInjection2");
        resourceInjection2.getResource();

    }

    @org.junit.Test
    public void testXmlBeanFactory() throws Exception {
        ClassPathResource res = new ClassPathResource("ResourceLoaderInjection.xml");
        XmlBeanFactory factory = new XmlBeanFactory(res);
        ResourceLoaderInjection2 injection2 = (ResourceLoaderInjection2) factory.getBean("resourceLoaderInjection2");
        injection2.getResource("ResourceLoaderInjection.xml");
    }

    /**
     * 直接使用DefaultResourceLoader的getResource()方法，
     * 判断location的路径是否以classpath:开头的，如果是则返回ClassPathResource的对象
     */
    @Test
    public void testResourceLoader() {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:simple-bean.xml");

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        reader.loadBeanDefinitions(resource);

        SimpleBeanImpl simpleBeanImpl = (SimpleBeanImpl) factory.getBean("simpleBeanImpl");

        simpleBeanImpl.sayHi();
    }

    /**
     * 直接使用DefaultResourceLoader的getResource()方法，
     * 使用location参数， 创建URL对象，如果是locatioin是协议名+://+path，则不报错， 否则抛异常，
     * 如果有抛异常，则创建ClassPathResouce对象
     */
    @Test
    public void testResourceLoaderURLResource() {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        //        String location = "http://simple-bean.xml";//标准的url， 创建UrlResouce对象
        //        String location = "file:d://simple-bean.xml";//标准的url， 创建UrlResouce对象
        //        String location = "simple-bean.xml";//创建ClassPathResouce对象
        String location = "d://simple-bean.xml";//创建ClassPathResouce对象, 但是从当前classpath下肯定找不到这个文件， 所以会报错， 找不到资源

        Resource resource = resourceLoader.getResource(location);

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        reader.loadBeanDefinitions(resource);

        SimpleBeanImpl simpleBeanImpl = (SimpleBeanImpl) factory.getBean("simpleBeanImpl");

        simpleBeanImpl.sayHi();
    }

    /**
     * 如何解决DefaultResouceLoader的getResourceByPath()方法，默认创建的是ClassPathResource资源
     */
    @Test
    public void testFileSystemResouceLoader() {
        FileSystemResourceLoader loader = new FileSystemResourceLoader();
        String location = "d://simple-bean.xml";
        Resource resource = loader.getResource(location);

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        reader.loadBeanDefinitions(resource);

        SimpleBeanImpl simpleBeanImpl = (SimpleBeanImpl) factory.getBean("simpleBeanImpl");

        simpleBeanImpl.sayHi();

    }

    /**
     * FileSystemXmlApplicationContext继承ResourceLoader， 重写getResourceByPath()方法
     */
    @Test
    public void testFileSystemXmlApplicationContext() {
        String location = "d://simple-bean.xml";
        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext(location);

        SimpleBeanImpl simpleBeanImpl = (SimpleBeanImpl) factory.getBean("simpleBeanImpl");

        simpleBeanImpl.sayHi();

    }

}
