package com.base.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by wanxiaotao on 15/9/30.
 */
public class FutrueTest2 {
    public static void main(String[] args) throws Exception{

        // 结束的倒数锁
        final CountDownLatch end = new CountDownLatch(2);

        List<Future<String>> result = new ArrayList<Future<String>>();

        ExecutorService executor = Executors.newCachedThreadPool();

        result.add(executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(6000);
                end.countDown();
                return "test1";
            }
        }));

        result.add(executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(6000);
                end.countDown();
                return "test2";
            }
        }));

        end.await(8000L,TimeUnit.MILLISECONDS);

        for (Future<String> future :result) {
            if(future.isDone()) {
                System.out.println(future.get());
            } else {
                System.out.println("取消线程");
                future.cancel(true);
            }
        }


//        Callable<Integer> callable = new Callable<Integer>() {
//            public Integer call() throws Exception {
//                Thread.sleep(8000);
//                return new Random().nextInt(100);
//            }
//        };
//        FutureTask<Integer> future = new FutureTask<Integer>(callable);
//
//        new Thread(future).start();
//
//        try {
//            System.out.println("begin");
//            Thread.sleep(5000);// 可能做一些事情
//            System.out.println("end");
//            future.wait(2);
//            System.out.println(future.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        System.out.print("end");

    }
}
