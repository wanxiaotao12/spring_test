package com.thread;

import java.util.Random;

/**
 * Created by hongming on 2015/8/14.
 */
public class Test {


    public static void main(String[] args) {


        User user = new User();
        user.setMoney(0);

        Dec dec = new Dec(user, 0);

        Thread thread = new Thread(dec, "thread1");
        Thread thread2 = new Thread(dec, "thread2");
        Thread thread3 = new Thread(dec, "thread3");
        Thread thread4 = new Thread(dec, "thread4");
        Thread thread5 = new Thread(dec, "thread5");

        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

    }

}

class Dec implements Runnable {

    public Integer num;

    private User user;

    public Dec(User user, int num) {
        this.user = user;
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            add(i);

        }
    }

    //    public synchronized void   add(int i) {
    public void add(int i) {
        int before = num;
        int beforeMoney = user.getMoney();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num++;
        user.setMoney(user.getMoney() + 1);
        int after = num;
        int afterMoney = user.getMoney();
        System.out.println(Thread.currentThread().getName() + " i=" + i + "   before=" + before + " , after=" + after);
        System.out.println(Thread.currentThread().getName() + " i=" + i + "   beforeMoney=" + beforeMoney + " , afterMoney=" + afterMoney);
    }
}


