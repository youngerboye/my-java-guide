package main.java.com.young.guide.base.thread;

/**
 * @author: young
 * @date: 2021/2/25
 */
public class Singleton {
    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public void method(){
        synchronized (this){
            System.out.println("sync代码块");
        }

    }

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
