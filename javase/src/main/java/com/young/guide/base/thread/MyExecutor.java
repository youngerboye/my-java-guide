package main.java.com.young.guide.base.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: young
 * @date: 2021/3/4
 */
public class MyExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//
//        for (int i = 0; i < 5; i++) {
//            executorService.execute(new MyRunnable());
//        }
//
//        executorService.shutdown();

//        Thread thread = new Thread(new MyRunnable());
//        thread.setDaemon(true);
//        thread.start();

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> haha = executorService.submit(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("haha");
            } catch (InterruptedException e) {
            }
            return "aaaaaaa";
        });
        String s = haha.get();
        executorService.shutdownNow();
        System.out.println(s);
    }
}

