package me.example.training.designpattern.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 饿汉
 *
 * JDK中的单例
 * @see Runtime
 *
 *
 * @author zhoujialiang9
 * @date 2022/6/10 2:15 PM
 **/
@Slf4j
public class Singleton1 {

    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1(){
    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }

    public void doSomething(){
        log.info("{}，doSomething", INSTANCE.getClass().getCanonicalName());
    }

}
