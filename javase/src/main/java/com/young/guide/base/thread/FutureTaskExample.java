package main.java.com.young.guide.base.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: young
 * @date: 2021/3/4
 */
public class FutureTaskExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int i = 0; i < 100; i++) {
                    result += i;
                    Thread.sleep(10);
                }
                return result;
            }
        });
        Thread thread = new Thread(futureTask);
        thread.start();

        Thread ohterTaskIsRunning = new Thread(() -> {
            System.out.println("ohter task is running");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        ohterTaskIsRunning.start();

        System.out.println(futureTask.get());
    }
}
