package main.java.com.young.guide.base.basedata;

/**
 * @author: young
 * @date: 2021/2/25
 * this关键字指当前类的实例
 */
public class Manager {

    void managerInit() {
        this.report();
    }

    public void report() {

    }
}

class Son extends Manager {
    void bar() {

        super.report();
        super.managerInit();
    }
}
