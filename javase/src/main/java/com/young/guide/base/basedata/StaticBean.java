package main.java.com.young.guide.base.basedata;

/**
 * @author: young
 * @date: 2021/2/25
 */
public class StaticBean {

     protected String name;

    /**
     * 定义一个静态变量
     */
    private static int age;

    public StaticBean(String name) {

        this.name = name;
    }

    public static void sayHello() {

        System.out.println("hello id am");
    }

    @Override
    public String toString() {
        return "StaticBean{" +
                "name='" + name + '\'' +
                "age=" + age  +
                '}';
    }

    public static void main(String[] args) {

        StaticBean staticBean = new StaticBean("1");
        StaticBean staticBean2 = new StaticBean("2");
        StaticBean staticBean3 = new StaticBean("3");
        StaticBean staticBean4 = new StaticBean("4");
        StaticBean.age = 33;
        System.out.println(staticBean + " " + staticBean2 + " " + staticBean3 + " " + staticBean4);

    }
}
