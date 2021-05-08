package main.java.com.young.guide.base.thread;

/**
 * @author: young
 * @date: 2021/2/25
 */
public class ThreadLocalExample {

    public static void main(String[] args) {
        ThreadLocal threadLocal1 = new ThreadLocal();
        ThreadLocal threadLocal2 = new ThreadLocal();
        Thread thread1 = new Thread(() -> {
            threadLocal1.set(1);
            threadLocal2.set(1);

            System.out.println(Thread.currentThread().getName()+
                    "\t"+threadLocal1.get());
            System.out.println(Thread.currentThread().getName()+
                    "\t"+threadLocal2.get());
        }, "thread1");
        Thread thread2 = new Thread(() -> {
            threadLocal1.set(2);
            threadLocal2.set(2);
            System.out.println(Thread.currentThread().getName()+
                    "\t"+threadLocal1.get());
            System.out.println(Thread.currentThread().getName()+
                    "\t"+threadLocal2.get());
        }, "thread2");
        thread1.start();
        thread2.start();
    }

//    //
//    private static final ThreadLocal<SimpleDateFormat> format =
//            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd " +
//                    "HH:mm"));
//
//    public static void main(String[] args) throws InterruptedException {
//        ThreadLocalExample obj = new ThreadLocalExample();
//        for (int i = 0; i < 10; i++) {
//            Thread t = new Thread(obj, "" + i);
//            Thread.sleep(new Random().nextInt(1000));
//            t.start();
//        }
//
//        ThreadLocal threadLocal = new ThreadLocal();
//        threadLocal.set("aaa");
//    }
//
//    @Override
//    public void run() {
//
//    }
}
