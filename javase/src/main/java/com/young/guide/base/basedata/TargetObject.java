package main.java.com.young.guide.base.basedata;

import lombok.ToString;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: young
 * @date: 2021/2/25
 */
@ToString
public class TargetObject {
    private String value;

    private int age;

    public TargetObject() {
        value = "guide";
    }



    public void publicMethod(String s) {
        System.out.println("I Love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> aClass = Class.forName("com.young.guide.base.basedata.TargetObject");

        Object aClassInstance = aClass.newInstance();

        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("method:" + declaredMethod.getName());
        }

        //通过反射获取公有方法
        Method publicMethod = aClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(aClassInstance, "you");

        //通过反射获取私有方法
        Method privateMethod = aClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(aClassInstance);

        //获取所有声明的字段
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("field:" + declaredField.getName());
        }
        Field age = aClass.getDeclaredField("age");
//        age.setAccessible(true);
        age.set(aClassInstance,20);
        System.out.println(aClassInstance);
    }
}
