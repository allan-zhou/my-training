package me.example.training.test.innerclass;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * 静态内部类
 *
 * @author zhoujialiang9
 * @date 2022/4/1 4:07 PM
 **/
@Slf4j
public class OutClass4 {

    private String name;

    private String city;

    public OutClass4(String name, String city) {
        this.name = name;
        this.city = city;

        log.info("outClass 初始化。");
    }

    @Override
    public String toString() {
        return "OutClass2{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public static class InnerClass{

        public InnerClass(){
            log.info("内部类初始化.");
        }


        // 可以包含静态变量
        public static String KEY = "key";

        // 可以包含静态方法
        public static void doSomething(){

            log.info("do Something...");

        }
    }

    public static void main(String[] args) {

        OutClass4.InnerClass.doSomething();

    }

}
