package me.example.training.java8.cls;

/**
 * @author zhoujialiang9
 * @date 2023/5/8 18:07
 **/
public class MethodHandleTypeDemo {
    public static void a(String s) {
        System.out.println("a: " + s);
    }

    public void b(String s) {
        System.out.println("b: " + s);
    }

    public static int c(String s1, String s2) {
        System.out.println("c: arg0: " + s1 + ", arg1:" + s2);
        return 1;
    }
}
