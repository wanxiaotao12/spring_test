package com.spring.bean.test;

/**
 * Created by xiaotao.wxt on 2014/8/13.
 */
public class SimpleBean3 {
    private String userName;

    public void test(){
        System.out.print("userName=" +userName);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
