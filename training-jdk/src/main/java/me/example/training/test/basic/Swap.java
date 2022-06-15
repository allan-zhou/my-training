package me.example.training.test.basic;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * 交换两个整数
 *
 * @author zhoujialiang9
 * @date 2022/6/15 3:38 PM
 **/
@Slf4j
public class Swap {

    public static void main(String[] args) {

        int a = 10;
        int b = 20;
        swap(a, b);
        log.info("主函数，swap后：a={}, b={}",a, b);

        // 方式1：使用数组
        Integer[] arr = new Integer[]{a, b};
        swapByArray(arr);
        log.info("主函数，swapByArray后：a={}, b={}",arr[0], arr[1]);

        // 方式2：使用对象封装
        MyIntClass myIntClass = new MyIntClass(10, 20);
        swapByObject(myIntClass);
        log.info("主函数，swapByObject后：a={}, b={}",myIntClass.a, myIntClass.b);
    }

    /**
     * 不能交换
     * @param a
     * @param b
     */
    @Deprecated
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

        log.info("swap内：a={}, b={}",a, b);
    }

    public static void swapByArray(Integer[] arrays){
        int temp = arrays[0];
        arrays[0] = arrays[1];
        arrays[1] = temp;

        log.info("swapByArray内：a={}, b={}",arrays[0], arrays[1]);
    }

    public static void swapByObject(MyIntClass myIntClass){
        int temp = myIntClass.a;
        myIntClass.a = myIntClass.b;
        myIntClass.b = temp;

        log.info("MyIntClass内：a={}, b={}", myIntClass.a, myIntClass.b);
    }

    public static class MyIntClass{
        private Integer a;
        private Integer b;

        public MyIntClass(Integer a, Integer b) {
            this.a = a;
            this.b = b;
        }

    }
}
