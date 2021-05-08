package main.java.com.young.guide.base.basedata;

/**
 * @author: young
 * @date: 2021/2/25
 * protected 修饰的方法和变量会被子继承，但是子类也只是可访问自己继承的方法和变量是不可以访问父类的，不同包下
 */
public class StaticBeanSon extends StaticBean {


    public StaticBeanSon(String name) {
        super(name);
        super.name="sss";
    }

    public static void main(String[] args) {
        StaticBean staticBean = new StaticBean("2");
        staticBean.name="ss";
        getUnique();
    }
    static {
        System.out.println();
    }

    private static class SingletonHolder{
        private static final StaticBeanSon instance = new StaticBeanSon("222");
    }

    public static StaticBeanSon getUnique(){
        return SingletonHolder.instance;
    }
}
