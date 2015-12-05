package com.base.thread.model;

/**
 * Created by wanxiaotao on 29/11/15.
 */
public class ReadWriteLockTest implements Runnable {

    private PricesInfo pricesInfo;

    public ReadWriteLockTest(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }
    @Override
    public void run() {
        for(int i = 0; i<3; i++) {
//            pricesInfo.getPrice();

            pricesInfo.setPrice();
        }
    }
}
