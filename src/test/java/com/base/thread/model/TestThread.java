package com.base.thread.model;

/**
 * Created by wanxiaotao on 28/11/15.
 */
public class TestThread extends Thread{

    public TestThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i=0 ;i< 1000;i++) {
            System.out.println(this.getName() + ":" + i);
        }
    }


}
