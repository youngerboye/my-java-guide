package main.java.com.young.guide.base.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: young
 * @date: 2021/2/23
 * 泛型
 */
public class GenericsTest {
    public static void main(String[] args) throws ClassNotFoundException {
        //首先 list的泛型会在代码编写时就确定数据类型
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        //list.add("sss");代码编写不通过

//        GenericsClass<Integer> genericsClass = new GenericsClass<>();
//
//        ClassLoader aClass = genericsClass.getClass().getClassLoader();
//        Class<?> genericsClass2 = Class.forName("com.young.guide.base.generic.GenericsClass");
////        System.out.println(aClass==genericsClass2);
//
//        System.out.println(genericsClass.getKey());

        List<Dog> dogs = new ArrayList<>();
        // 不会报错
        System.out.println(countLegs(dogs));
        // 报错
//        System.out.println(countLegs1(dogs));

        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);
        System.out.println("i4=i5   " + (i4 == i5));
        System.out.println("i4=i5+i6   " + (i4 == i5 + i6));
        System.out.println("40=i5+i6   " + (40 == i5 + i6));
        System.out.println(2<<2);
    }

    static int countLegs(List<? extends Animal> animals) {
        int retval = 0;
        for (Animal animal : animals) {
            retval += animal.countLegs();
        }
        return retval;
    }

    static int countLegs1(List<Animal> animals) {
        int retval = 0;
        for (Animal animal : animals) {
            retval += animal.countLegs();
        }
        return retval;
    }
}

//泛型类
class GenericsClass<T> {
    private T t;

    public GenericsClass() {
    }

    public GenericsClass(T t) {
        this.t = t;
    }

    public T getKey() {
        return t;
    }
}

class Animal {
    public int countLegs() {
        return 1;
    }
}

class Dog extends Animal{

}
