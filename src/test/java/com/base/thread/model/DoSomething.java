package com.base.thread.model;

/**
 * Created by wanxiaotao on 28/11/15.
 */
public class DoSomething implements Runnable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DoSomething(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        for(int i=0;i<1000;i++) {
            if(i%10==0 && "张三".equals(name)) {
                Thread.yield();
            }
            System.out.println(name + ": " + i + ", " + Thread.currentThread().getName());
        }
    }
}
