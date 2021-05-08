package main.java.com.young.guide.base.valueRef;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

/**
 * @author: young
 * @date: 2021/2/23
 */
public class ValueRefDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Student s1 = new Student("小张");
//        Student s2 = new Student("小王");
//        swap(s1, s2);
//        System.out.println("s1:" + s1.getName());
//        System.out.println("s2:" + s2.getName());

//        int num1 = 10;
//        int num2 = 20;
//        swap(num1,num2);
//        System.out.println("num1 = " + num1);
//        System.out.println("num2 = " + num2);


//        int[] arr = {1, 2, 3, 4};
//        System.out.println(Arrays.toString(arr));
//        change(arr);
//        System.out.println(Arrays.toString(arr));


        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        Iterator<String> i = list.iterator();
        while (i.hasNext()) {
            String next = i.next();
            if (Objects.equals("2", next)) {
                i.remove();
            }
        }
        System.out.println(list);

//        for (String s : list) {
//            if (Objects.equals("2",s)) {
//                list.remove(s);
//            }
//        }

//        System.out.println(list);

        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(10, 100, 10,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000));
        Future<?> hello = executor.submit(() -> {
            System.out.println("hello");
            return 1;
        });
        System.out.println(hello.get());
    }

    public static void change(int[] array1) {
        // 将数组的第一个元素变为0
        array1[0] = 0;
    }

    public static void swap(Student x, Student y) {
        x = new Student("小杨");
        System.out.println("x:" + x.getName());
        System.out.println("y:" + y.getName());
    }


    public static void swap(int a, int b) {
        a = 10;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
