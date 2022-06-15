package me.example.training.designpattern.singleton;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.Proxy;

/**
 * @author zhoujialiang9
 * @date 2022/6/10 2:14 PM
 **/
@Slf4j
public class Main {

    public static void main(String[] args) {

        Singleton1 singleton1 = Singleton1.getInstance();
        singleton1.doSomething();

        Singleton12 singleton12 = Singleton12.getInstance();
        singleton12.doSomething();

        Singleton13 singleton13 = Singleton13.INSTANCE;
        singleton13.doSomething();

        Singleton2 singleton2 = Singleton2.getInstance();
        singleton2.doSomething();

        try {

            // 通过反射，可以破坏单例
            Class<Singleton2> singleton2Class = Singleton2.class;
            Constructor constructor = singleton2Class.getDeclaredConstructor();
            constructor.setAccessible(true);

            Singleton2 singleton2Ref = (Singleton2)constructor.newInstance();
            singleton2Ref.doSomething();

            log.info("singleton2 == singleton2Ref, result={}", singleton2 == singleton2Ref);

        } catch (Exception e) {
            log.info("error", e);
        }


        Singleton3 singleton3 = Singleton3.getInstance();
        singleton3.doSomething();
    }
}
