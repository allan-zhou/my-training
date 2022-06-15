package me.example.training.designpattern.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 饿汉-方式2
 *
 * @author zhoujialiang9
 * @date 2022/6/10 2:24 PM
 **/
@Slf4j
public class Singleton12 {
    private final static Singleton12 INSTANCE;

    private Singleton12(){
    }

    public static Singleton12 getInstance() {
        return INSTANCE;
    }

    /**
     * 使用静态代码片
     */
    static {
        INSTANCE = new Singleton12();
    }

    public void doSomething(){
        log.info("{}，doSomething", INSTANCE.getClass().getCanonicalName());
    }
}
