package main.java.com.young.guide.base.basedata;

import java.lang.reflect.Method;

/**
 * @author: young
 * @date: 2021/2/25
 */
public class Student2 {
    public void show1(String s) {
        System.out.println("调用了公有的，string参数的show1()方法：参数s=" + s);
    }

    protected void show2() {
        System.out.println("调用了受保护的show2()方法");
    }

    void show3(String s) {
        System.out.println("调用了默认的show3()方法");
    }

    private String show4(int age) {
        System.out.println("调用了私有的int参数的show4()方法：参数age=" + age);
        return "abcd";
    }

    public static void main(String[] args) throws Exception {
        //1.获取类
        Class<?> studentClass = Class.forName("com.young.guide.base.basedata.Student2");
        //2.获取公有的方法
        System.out.println("-------获取所有的公有方法-----");
        Method[] methods = studentClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        //3获取所有的方法包括私有方法a
        System.out.println("----获取所有的方法(包含公有私有)----------");
        Method[] declaredMethods = studentClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        //4.获取某一个公有方法
        System.out.println("-----获取某一个公有方法---");
        Method show1 = studentClass.getMethod("show1", String.class);
        System.out.println(show1);
        Object o = studentClass.newInstance();
        show1.setAccessible(true);
        show1.invoke(o,"刘德华");

        //5.获取某个私有方法
        System.out.println("-------获取某个私有方法--------");
        Method show4 = studentClass.getDeclaredMethod("show4", int.class);
        System.out.println(show4);
        show4.setAccessible(true);
        Object invoke = show4.invoke(o, 20);
        System.out.println("返回值是:"+invoke);
    }
}
