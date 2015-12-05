package com.base.thread.model;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by wanxiaotao on 29/11/15.
 */
public class PricesInfo {
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    private int price = 100;

    public int getPrice(){
        lock.readLock().lock();
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ", price=" + price);
        lock.readLock().unlock();

        return price;
    }


    public void setPrice() {
        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + ", set");
        price = price + 1;

        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + ", set out");
    }
}
