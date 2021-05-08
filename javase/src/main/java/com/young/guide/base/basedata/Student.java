package main.java.com.young.guide.base.basedata;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author: young
 * @date: 2021/2/25
 * 1、反射机制构造方法
 *   1.1获取class方式
 *     1.1.1 Object类的方法
 *     Student student = new Student();
 *     Class StudentClass1 = student.getClass();
 *
 *     1.1.2
 *     Class studentClass2 = Student.class;
 *
 *     1.1.3
 *     Class studentClass3 = Class.forName("com.xxx.xx.Student");
 *
 */
public class Student {

    Student(String str){
        System.out.println("默认的构造方法s="+str);
    }

    public Student(){
        System.out.println("调用了公有的无参构造方法");
    }

    //构造方法
    public Student(char name){
        System.out.println("学生的姓名是:"+name);
    }

    //多个参数的构造方法
    public Student(String name,int age){
        System.out.println("姓名是:"+name+"年龄是:"+age);
    }

    protected Student(boolean name){
        System.out.println("受保护的构造方法n="+name);
    }

    //私有的构造方法
    private Student(int age){
        System.out.println("私有的构造方法 年纪:"+age);
    }
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Student student = new Student();
        //第一种获取class对象
        Class<? extends Student> studentClass1 = student.getClass();
        System.out.println(studentClass1.getName());

        //第二种方式获取class对象
        Class<Student> studentClass2 = Student.class;
        System.out.println(studentClass2.getName());
        System.out.println(studentClass1 == studentClass2);

        Class<?> studentClass3 = Class.forName("com.young.guide.base.basedata.Student");
        System.out.println(studentClass3.getName());
        System.out.println(studentClass1 == studentClass3);

        //获取所有的公有的构造方法
        System.out.println("------获取公有构造方法---------");
        Constructor<?>[] publicContr = studentClass3.getConstructors();
        for (Constructor<?> constructor : publicContr) {
            System.out.println(constructor);
        }

        System.out.println("-----获取所有的构造方法（包括公有私有）------");
        Constructor<?>[] declaredConstructors = studentClass3.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        System.out.println("-------获取公有无参构造----------");
        Constructor<?> constructorNoParm = studentClass3.getConstructor(null);
        System.out.println(constructorNoParm);

        System.out.println("------调用私有的构造------");
        Constructor<?> declaredConstructor =
                studentClass3.getDeclaredConstructor(int.class);
        declaredConstructor.setAccessible(true);
        declaredConstructor.newInstance(20);


    }
}
