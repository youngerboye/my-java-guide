package main.java.com.young.guide.base.thread;

import lombok.SneakyThrows;

/**
 * @author: young
 * @date: 2021/2/25
 */
public class ObjectService {
    public void serviceMethodA() throws InterruptedException {
        synchronized (this) {
            System.out.println("A begin time=" + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("A end time=" + System.currentTimeMillis());
        }
    }

    public void serviceMethodB() {
        synchronized (this) {
            System.out.println("B begin time=" + System.currentTimeMillis());
            System.out.println("B end time=" + System.currentTimeMillis());
        }
    }
}

class ThreadA extends Thread {
    private ObjectService objectService;

    public ThreadA(ObjectService objectService) {
        super();
        this.objectService = objectService;
    }

    @SneakyThrows
    @Override
    public void run() {
        super.run();
        objectService.serviceMethodA();
    }
}

class ThreadB extends Thread {
    private ObjectService objectService;

    public ThreadB(ObjectService objectService) {
        super();
        this.objectService = objectService;
    }

    @SneakyThrows
    @Override
    public void run() {
        super.run();
        objectService.serviceMethodB();
    }
}

class MainTest {
    public static void main(String[] args) {
        ObjectService service = new ObjectService();
        ThreadA aThread = new ThreadA(service);

        aThread.setName("a");
        aThread.start();

        ThreadB b = new ThreadB(service);
        b.setName("b");
        b.start();
    }
}
