package main.java.com.young.guide.base.basedata;

/**
 * @author: young
 * @date: 2021/2/25
 * 静态代码块和非静态代码块
 */
public class StaticTest {
    static {
        System.out.println("静态代码块执行");
    }

    {
        System.out.println("非静态代码块执行");
    }

    public static void main(String[] args) {
        StaticTest staticTest = new StaticTest();

        StaticBean staticBean = new StaticBean("1");
        staticBean.name="sss";
    }

    public StaticTest() {
        System.out.println("构造方法执行");
    }

    public void gen() {
        System.out.println("普通方法执行");
    }
}
