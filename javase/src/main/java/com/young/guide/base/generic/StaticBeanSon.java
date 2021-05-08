package main.java.com.young.guide.base.generic;

import main.java.com.young.guide.base.basedata.StaticBean;

/**
 * @author: young
 * @date: 2021/2/25
 * protected 修饰的方法和变量会被子继承，但是子类也只是可访问自己继承的方法和变量是不可以访问父类的，不同包下
 */
public class StaticBeanSon extends StaticBean {

    public StaticBeanSon(String name) {
        super(name);
        StaticBean staticBean = new StaticBean("2");
        super.name="1";
    }

    public static void main(String[] args) {
        StaticBean staticBean = new StaticBean("2");
    }
}
