package me.example.training.test.innerclass;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * 匿名内部类 , 本质上是实例化了一个接口
 *
 * @author zhoujialiang9
 * @date 2022/4/1 3:55 PM
 **/
@Slf4j
public class OutClass3 {

    private String name;

    private String city;

    public OutClass3(String name, String city) {
        this.name = name;
        this.city = city;

        log.info("outClass 初始化。");
    }

    public Runnable doSomething(){

        return new Runnable() {
            @Override
            public void run() {

                log.info("do something...");

            }
        };
    }

    public static void main(String[] args) {

        OutClass3 outClass3 = new OutClass3("zhang san", "beijing");

        Runnable runnable = outClass3.doSomething();
        runnable.run();
    }

}
