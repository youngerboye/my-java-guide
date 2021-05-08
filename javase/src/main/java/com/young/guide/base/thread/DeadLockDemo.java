package main.java.com.young.guide.base.thread;

/**
 * @author: young
 * @date: 2021/2/25
 */
public class DeadLockDemo {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (resource1){
                System.out.println(Thread.currentThread().getName()+",get " +
                        "resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread().getName()+",waiting" +
                        " get " +
                        "resource2");

                synchronized (resource2){
                    System.out.println(Thread.currentThread().getName()+",get" +
                            " resource2");
                }
            }
        },"线程1").start();

        new Thread(()->{
            synchronized (resource2){
                System.out.println(Thread.currentThread().getName()+",get " +
                        "resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread().getName()+",waiting" +
                        " get " +
                        "resource1");

                synchronized (resource1){
                    System.out.println(Thread.currentThread().getName()+",get" +
                            " " +
                            "resource1");
                }
            }
        },"线程2").start();
    }
}
