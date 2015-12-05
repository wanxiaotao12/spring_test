package com.base.thread;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * 线程倒数计数器
 * 使用场景：有一个线程需要等待其他线程都执行完成后， 才能执行，
 *
 * 如：数据源是多个， 先将每个数据源的数据都取到， 然后汇总， 这种情况就可以使用CountDownLatch,
 * 开启多个线程请求对应的数据， 然后主线程(汇总线程)等待所有数据都取回来， 进行汇总
 *
 * 参考：http://www.cnblogs.com/dolphin0520/p/3920397.html
 * Created by wanxiaotao on 5/12/15.
 */
public class CountDownLatchTest {

    @Test
    public void test() {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread thread1 = new ThreadTest("线程1", countDownLatch);
        Thread thread2 = new ThreadTest("线程2", countDownLatch);

        thread1.start();
        thread2.start();

        try {
            //等待线程1，线程2结束， 这里的等待可以设置等待的超时时间
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    class ThreadTest extends Thread {

        private CountDownLatch countDownLatch;

        ThreadTest(String name, CountDownLatch countDownLatch) {
            this.setName(name);
            this.setCountDownLatch(countDownLatch);
        }

        public CountDownLatch getCountDownLatch() {
            return countDownLatch;
        }

        public void setCountDownLatch(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " start");
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //计数器减1
            countDownLatch.countDown();

            System.out.println(Thread.currentThread().getName() + "end");
        }
    }

}
