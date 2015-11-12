package com.base.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by wanxiaotao on 15/9/30.
 */
public class FutrueTest {

    public static void main(String[] args) {
        long startTime1 = System.currentTimeMillis();

//        CountDownLatch end = new CountDownLatch(2);
//
//        List<Future<List<ConsumInfo>>> futrueResult = new ArrayList<Future<List<ConsumInfo>>>();
//
//        futrueResult.add(executor.submit(new Callable<List<ConsumInfo>>() {
//            @Override
//            public List<ConsumInfo> call() throws Exception {
//                List<ConsumInfo> result = getList(getPrePayConsumList(param));
//                logger.info(" end8");
//                end.countDown();
//                return result;
//            }
//        }));
//
//        futrueResult.add(executor.submit(new Callable<List<ConsumInfo> >() {
//            @Override
//            public List<ConsumInfo>  call() throws Exception {
//                List<ConsumInfo> result = getList(getPostPayConsumList(param));
//                end.countDown();
//                return result;
//            }
//        }));
//
//        end.await(10000L, TimeUnit.MILLISECONDS);
//
//
//        boolean flag = true;
//        for (Future<List<ConsumInfo>> future : futrueResult) {
//            if (future.isDone()) {
////                    mergerData.addAll(future.get());
//            } else {
//                flag = false;
//                future.cancel(true);
//            }
//        }
//
//        long endTime1 = System.currentTimeMillis();
//
//        logger.info("time1:" + (endTime1 - startTime1));
//
//        if (!flag) {
//            return ResponseBaseResult.createErrorResponse(requestId, ResultCodeConstants.SYS_ERROR);
//        }
    }
}
