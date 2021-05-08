package main.java.com.young.guide.base.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author: young
 * @date: 2021/3/4
 */
public class SemaphoreExample {
    public static void main(String[] args) {
        final int totalThreadCount = 10;
        final int clientCount = 3;

        Semaphore semaphore = new Semaphore(clientCount);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < totalThreadCount; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    System.out.print(semaphore.availablePermits() + " ");
                }catch (Exception e){
                } finally{
                    semaphore.release();
                }
            });
        }
        executorService.shutdown();

    }
}
