package com.spring.bean;

/**
 * Created by IntelliJ IDEA.
 * User: wan
 * Date: 13-7-31
 * To change this template use File | Settings | File Templates.
 */
public class BeanImpl implements Bean {
    private int age;
    private Bean2 bean2;
    private Bean3 bean3;
//    private Date utilDate;
    private String userName;

    @Override
    public void say() {
        System.out.println("age=" + age + ", userName="+userName);
        bean2.test2();
//        bean3.test3();
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setBean2(Bean2 bean2) {
        this.bean2 = bean2;
    }

//    public void setUtilDate(Date utilDate) {
//        this.utilDate = utilDate;
//    }

    public void setBean3(Bean3 bean3) {
        this.bean3 = bean3;
    }

}
