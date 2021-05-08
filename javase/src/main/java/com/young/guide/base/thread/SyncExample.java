package main.java.com.young.guide.base.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: young
 * @date: 2021/3/4
 */
public class SyncExample {
    public void func1() {
        Lock lock = new ReentrantLock();
        lock.lock();
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        lock.unlock();
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        SyncExample syncExample1 = new SyncExample();
        SyncExample syncExample2 = new SyncExample();

        //对于不同对象锁对象就不行了synchronized (this)
        executorService.execute(() -> syncExample1.func1());
        executorService.execute(() -> syncExample1.func1());

        //如果是synchronized (SyncExample.class)锁住这个类就可以
//        executorService.execute(() -> syncExample1.func1());
//        executorService.execute(() -> syncExample2.func1());
        //0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9
    }
}
