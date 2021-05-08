package main.java.com.young.guide.base.addOrDecr;

/**
 * @author: young
 * @date: 2021/2/23
 * 自增自减
 * 可以得出a++或者++a如果不赋值给a那就在原数字上加1
 * 符号在前就先加/减，符号在后就后加/减
 */
public class AddOrDecDemo {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        b=++a;

        System.out.println(b);
        System.out.println(a);
    }
}
