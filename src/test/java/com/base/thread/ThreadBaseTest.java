package com.base.thread;

import com.base.thread.model.*;
import org.junit.Test;

/**
 * Created by wanxiaotao on 28/11/15.
 */
public class ThreadBaseTest {

    /**
     * 1、线程的名称: 线程名字有两个来源，一个是虚拟机自己给的名字，一个是代码中指定的名字，
     *   如果没有指定， 则使用虚拟机指定的，默认指定的主线程名：main, 非主线程名：不确定
     *
     * 2、线程一旦执行完， 则不可以再重新启动
     *
     * 3、线程的调度无法确定，但是可以通过别的方式影响调度
     *
     * 4、线main方法 主线程放在一个栈， 其他的非主线程放在新的栈
     *
     * 5、Thread.yield()方法， 使用当前运行的线程回到【可运行】状态
     *
     * 6、t1.join()，保证当前线程停止执行，直到该线程所加入的线程(t1)完成为止
     *
     * 7、关于线程死锁，理论上可能发生， 但是实际不一定真的会发生
     */
    @Test
    public void testRunnable(){
        Thread t = Thread.currentThread();
        //打印当前的线程， 因是主线程， 所以线程名称：main
        System.out.println(t.getName());

        DoSomething zhansan = new DoSomething("张三");
        DoSomething lisi = new DoSomething("李四");

        Thread t1 = new Thread(zhansan);
        Thread t2 = new Thread(lisi);

        t1.start();

        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 守护线程
     * JVM的垃圾回收、内存管理等线程都是守护线程。还有就是在做数据库应用时候，使用的数据库连接池，连接池本身也包含着很多后台线程，监控连接个数、超时时间、状态等等。
     */
    @Test
    public void testDaemon(){
        DoSomething zhansan = new DoSomething("张三");

        Thread t1 = new Thread(zhansan);
        //设置为守护线程
        t1.setDaemon(true);
        t1.start();
    }

    /**
     * 使用 Thread的继承方式
     */
    @Test
    public void testThread(){
        TestThread zhansan = new TestThread("张三");
        TestThread lisi = new TestThread("李四");

        zhansan.start();
        lisi.start();
    }


    @Test
    public void testLock() throws InterruptedException {
        LockTest lockTest = new LockTest();

        Thread t1 = new Thread(lockTest,"thread1");
        Thread t2 = new Thread(lockTest,"thread2");
        t1.start();
        t2.start();

        Thread.sleep(3000l);
    }


    @Test
    public void testLock2() throws InterruptedException {
        PricesInfo lockTest = new PricesInfo();

        ReadWriteLockTest readWriteLockTest = new ReadWriteLockTest(lockTest);

        Thread t1 = new Thread(readWriteLockTest,"thread1");
        Thread t2 = new Thread(readWriteLockTest,"thread2");
        t1.start();
        t2.start();

        Thread.sleep(9000l);
    }



}
