package main.java.com.young.guide.base.conorbrorre;

/**
 * @author: young
 * @date: 2021/2/23
 * continue关键字是跳出本次循环继续执行下一次循环
 * break关键字是跳出这个循环，执行循环下面的代码，
 * return 是将整个方法结束
 */
public class ContinueAndBreakAndReturn {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print("i="+i+",");
            for (int j = 0; j < 20; j++) {
                if(j==10){
                    return;
                }
                System.out.print("j="+j+",");
            }
            System.out.println();
        }
    }
}
