package com.base.thread;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 一组线程互相等待，直到到达某个公共屏障点， 然后同时执行
 *
 * 我们称为【barrier】状态
 * 当某个线程调用await方法后，当前线程进入【barrier】状态
 *
 * 可重复使用：当所有线程都达到【barrier】状态， CyclicBarrier实例可以再次使用
 *
 * 参考：http://www.cnblogs.com/dolphin0520/p/3920397.html
 *
 * CyclicBarrier 也可以模拟：主线程等待子线程执行完毕后， 才能再执行
 * Created by wanxiaotao on 5/12/15.
 */
public class CyclicBarrierTest {

    @Test
    public void test() {
        //        CyclicBarrier barrier = new CyclicBarrier(3);
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("当前执行线程：" + Thread.currentThread().getName());
            }
        });

        ThreadTest t1 = new ThreadTest("thread1", barrier);
        ThreadTest t2 = new ThreadTest("thread2", barrier);

        t1.start();
        t2.start();


        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("主线程执行");
        System.out.println("CyclicBarrier重用");

        ThreadTest t3 = new ThreadTest("thread3", barrier);
        ThreadTest t4 = new ThreadTest("thread4", barrier);

        t3.start();
        t4.start();

        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }


    class ThreadTest extends Thread {
        private CyclicBarrier cyclicBarrier;

        ThreadTest(String name, CyclicBarrier cyclicBarrier) {
            this.setName(name);
            this.setCyclicBarrier(cyclicBarrier);
        }

        public CyclicBarrier getCyclicBarrier() {
            return cyclicBarrier;
        }

        public void setCyclicBarrier(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " start");

            try {
                if (Thread.currentThread().getName().equals("thread1")) {
                    Thread.sleep(2000L);
                } else {
                    Thread.sleep(4000L);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                // await 也可以指定等待最长时间，如果超时，则会中止等待，继续执行
                cyclicBarrier.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "接续执行");

        }
    }
}
