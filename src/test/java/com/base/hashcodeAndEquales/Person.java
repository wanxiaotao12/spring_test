package com.base.hashcodeAndEquales;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by wanxiaotao on 12/11/15.
 */
public class Person {

    private String userName;


    private String age;

    Person(String userName, String age){
        this.userName = userName;
        this.age = age;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        System.out.println("*******调用hashCode方法********");
        int hashCode = 1;
        if(StringUtils.isNotBlank(this.getUserName())) {
            hashCode =  hashCode+ this.getUserName().hashCode();
        }

//        if(StringUtils.isNotBlank(this.getAge())) {
//            hashCode = hashCode + this.getAge().hashCode();
//        }

        System.out.println("HashCode: " + hashCode +  ", userName:" + this.getUserName()+"," + this.getAge());
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("*******调用equals方法********");
        if(obj == null) {
            return false;
        }

        if(!(obj instanceof Person)) {
            return false;
        }

        // 地址相等，返回true;
        if(obj==this) {
            return true;
        }

        Person person = (Person)obj;

        System.out.println("this info :" + this.getUserName() + ", " + this.getAge());
        System.out.println("obj info :" + person.getUserName() + ", " + person.getAge());

        if(StringUtils.isBlank(this.getUserName()) || StringUtils.isBlank(this.getAge())
                || StringUtils.isBlank(person.getUserName()) || StringUtils.isBlank(person.getAge())) {
            return false;
        }

        if(this.getUserName().equals(person.getUserName())
                && this.getAge().equals(person.getAge())) {
            return true;
        }

        return false;
    }
}
