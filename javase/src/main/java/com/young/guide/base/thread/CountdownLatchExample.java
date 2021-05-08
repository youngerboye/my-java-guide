package main.java.com.young.guide.base.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: young
 * @date: 2021/3/4
 */
public class CountdownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        final int totalThreadCount = 10;

        AtomicInteger atomicInteger = new AtomicInteger(0);
        CountDownLatch countDownLatch = new CountDownLatch(totalThreadCount);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < totalThreadCount; i++) {
             atomicInteger.incrementAndGet();
            executorService.execute(()->{
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println(atomicInteger);
        executorService.shutdown();
    }


}
