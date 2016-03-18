package com.base.thread;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * һ���̻߳���ȴ���ֱ������ĳ���������ϵ㣬 Ȼ��ͬʱִ��
 *
 * ���ǳ�Ϊ��barrier��״̬
 * ��ĳ���̵߳���await�����󣬵�ǰ�߳̽��롾barrier��״̬
 *
 * ���ظ�ʹ�ã��������̶߳��ﵽ��barrier��״̬�� CyclicBarrierʵ�������ٴ�ʹ��
 *
 * �ο���http://www.cnblogs.com/dolphin0520/p/3920397.html
 *
 * CyclicBarrier Ҳ����ģ�⣺���̵߳ȴ����߳�ִ����Ϻ� ������ִ��
 * Created by wanxiaotao on 5/12/15.
 */
public class CyclicBarrierTest {

    @Test
    public void test() {
        //        CyclicBarrier barrier = new CyclicBarrier(3);
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("��ǰִ���̣߳�" + Thread.currentThread().getName());
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

        System.out.println("���߳�ִ��");
        System.out.println("CyclicBarrier����");

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
                // await Ҳ����ָ���ȴ��ʱ�䣬�����ʱ�������ֹ�ȴ�������ִ��
                cyclicBarrier.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "����ִ��");

        }
    }
}
