package main.java.com.young.guide.base.basedata;

import java.lang.reflect.Field;

/**
 * @author: young
 * @date: 2021/2/25
 * 反射之字段
 */
public class Student1 {

    public Student1() {

    }

    public String name;
    protected int age;
    char sex;
    private String phoneNumber;

    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        //1.获取class对象
        Class<?> studentClass = Class.forName("com.young.guide.base.basedata.Student1");
        //2.获取字段
        System.out.println("--------获取所有公有字段------");
        Field[] fields = studentClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        //3.获取所有字段
        System.out.println("-----获取所有字段（包括公有，私有等）------");
        Field[] declaredFields = studentClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        //4.获取公有字段并且调用
        System.out.println("------获取公有字段并且使用--------");
        Field name = studentClass.getField("name");
        System.out.println(name);

        Object o = studentClass.newInstance();
        name.setAccessible(true);
        name.set(o,"刘德华");
        System.out.println(o);

        //5.获取私有字段并且调用
        Field phoneNumber = studentClass.getDeclaredField("phoneNumber");
        System.out.println(phoneNumber);

        Object o1 = studentClass.newInstance();
        phoneNumber.setAccessible(true);
        phoneNumber.set(o1,"123456");
        System.out.println(o1);
    }
}
