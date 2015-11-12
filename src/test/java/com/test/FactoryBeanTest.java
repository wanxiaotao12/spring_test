package com.test;

import com.spring.bean.factorybean.Product;
import com.spring.bean.factorybean.ProductType;
import com.spring.bean.factorybean.impl.ProductImpl2;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 工厂bean的测试
 * 问题：
 1、某一对象A依赖于接口B， 当使用spring为对象A注入接口B的实现类时， 接口B的实现类可能不确定，对于这种情况我们怎么处理？

 2、某一对象A依赖于接口B， 但是接口B的实现类， 依赖于第三方库， 第三方库需要初始化、处理相关的类， 这种情况我们怎么处理？

 针对上面的情况， 我们可以自己创建一个工厂， 让工厂创建所需要的实现类， 然后注入到对象A中

 * Created by xiaotao.wxt on 2014/8/14.
 */
public class FactoryBeanTest {

    /**
     * 静态工厂， 只能返回某一种接口的实现类bean, 尽管是可以向staticFactory中传参数， 但是参数也是在配置文件中写死的
     *
     * 配置文件， 怪异的是属性并不是依赖于ProductType接口的实现类bean, 而是一个别外一个无关的bean
     *
     * 这里要分析的是， staticFactory spring将其转化成什么， 其他依赖static
     *
     * 实例化静态工厂bean时， 并不用实例化好静态工厂， 而反射执行静态工厂中的静态方法， 生成目标实例
     *
     */
@Test
public void testStaticFactory(){
    ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("factorybean/staticfactory.xml");
    Product product = (Product) factory.getBean("product");
    product.getProduct();
}

    /**
     * 实例工厂方法
     * 与静态工厂方法的不同：
     * 实例工厂的bean需要实例化，
     * 当实例化<bean id="productType" factory-bean="noStaticFactory" factory-method="getBeanInstance" />时，
     *
     * 找到已经实例化好的noStaticFactory, 及生成对象的getBeanInstance方法， 反射生成目标bean,
     *
     * 并将 beanName=productType,  生成的目标bean注入到beanfactory中
     */
    @Test
    public void testNoStaticFactory(){
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("factorybean/nostaticfactory.xml");

        Product product = (Product) factory.getBean("product");

        product.getProduct();
    }


    /**
     * 继承spring中的FactoryBean
     */
    @Test
    public void testCustomFactoryBean(){
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("factorybean/beanfactory.xml");

        ProductType productType = (ProductType) factory.getBean("productType");

        productType.getProductType("123");
    }


    @Test
    public void testCustomFactoryBean2(){
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("factorybean/beanfactory2.xml");

        ProductImpl2 user = (ProductImpl2) factory.getBean("product");

        user.test();
    }
}
