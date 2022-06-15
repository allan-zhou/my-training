package me.example.training.designpattern.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 饿汉-方式3
 *
 * @author zhoujialiang9
 * @date 2022/6/10 2:26 PM
 **/
@Slf4j
public enum Singleton13 {
    INSTANCE;

    public void doSomething(){
        log.info("{}，doSomething", INSTANCE.getClass().getCanonicalName());
    }
}
