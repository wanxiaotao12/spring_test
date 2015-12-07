package com.base.thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * 参考：http://cmsblogs.com/?p=1284
 * Created by wanxiaotao on 6/12/15.
 */
public class ThreadPoolTest {

    /**
     * 执行结果：
     * pool-1-thread-1 正在运行
     * pool-1-thread-1 正在运行
     * pool-1-thread-1 正在运行
     * <p/>
     * 从执行的结果来看，虽然创建3个线程，3个线程都有名称，但是没有启动3个线程(调用线程的start()方法)
     * <p/>
     * 使用线程池来执行线程，则会使用线程池创建的线程，如：线程的名字pool-1-thread-1
     */
    @Test
    public void testSingleThread() {
        ExecutorService pool = Executors.newSingleThreadExecutor();

        MyThread t1 = new MyThread("thread1");
        MyThread t2 = new MyThread("thread2");
        MyThread t3 = new MyThread("thread3");
        MyThread t4 = new MyThread("thread4");
        MyThread t5 = new MyThread("thread5");


        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);

        pool.shutdown();
    }

    /**
     * 执行结果：pool-1-thread-1 正在运行
     * pool-1-thread-3 正在运行
     * pool-1-thread-2 正在运行
     * pool-1-thread-3 正在运行
     * pool-1-thread-1 正在运行
     */
    @Test
    public void testFixedThread() {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        MyThread t1 = new MyThread("thread1");
        MyThread t2 = new MyThread("thread2");
        MyThread t3 = new MyThread("thread3");
        MyThread t4 = new MyThread("thread4");
        MyThread t5 = new MyThread("thread5");


        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);

        pool.shutdown();
    }

    /**
     * 创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，
     * 那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，此线程池又可以智能的添加新线程来处理任务。
     *
     * 此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。
     * pool-1-thread-1 正在运行
     * pool-1-thread-2 正在运行
     * pool-1-thread-3 正在运行
     * pool-1-thread-4 正在运行
     * pool-1-thread-3 正在运行
     */
    @Test
    public void testCachedThread() {
        ExecutorService pool = Executors.newCachedThreadPool();

        MyThread t1 = new MyThread("thread1");
        MyThread t2 = new MyThread("thread2");
        MyThread t3 = new MyThread("thread3");
        MyThread t4 = new MyThread("thread4");
        MyThread t5 = new MyThread("thread5");


        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);

        pool.shutdown();
    }

    @Test
    public void testScheduledThread() throws Exception{
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);

        pool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("dddddddddd");
            }
        }, 1000, 5000, TimeUnit.MILLISECONDS);

//        pool.shutdown();

        Thread.sleep(10000L);
    }


    static class MyThread extends Thread {

        MyThread(String name) {
            this.setName(name);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " 正在运行");
        }
    }


}
