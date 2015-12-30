package com.base.thread.model;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wanxiaotao on 28/11/15.
 */
public class LockTest implements Runnable {
    private Lock lock = new ReentrantLock();
    private Condition condition =  lock.newCondition();


    private int num = 100;
    @Override
    public void run() {
        lock.lock();
        for(int i =0 ;i<10;i++) {
            num = num + 1;
            try {
                Thread.sleep(100l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ", num="+num);
        }
        lock.unlock();
    }
}
