package me.example.training.designpattern.singleton;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 容器模式
 *
 * nacos中的实现：
 * com.alibaba.nacos.client.auth.ram.identify.CredentialService
 *
 *
 * @author zhoujialiang9
 * @date 2022/6/10 6:05 PM
 **/
@Slf4j
public class Singleton3 {
    private final static String DEFAULT_NAME = "default";

    private static ConcurrentHashMap<String, Singleton3> map = new ConcurrentHashMap<>();

    private Singleton3(){
    }

    public static Singleton3 getInstance() {
        return getInstance(DEFAULT_NAME);
    }

    public static Singleton3 getInstance(String name) {

        Singleton3 instance = map.get(name);
        if(instance != null) {
            return instance;
        }

        instance = new Singleton3();
        Singleton3 tempInstance = map.putIfAbsent(name, instance);
        if(tempInstance != null) {
            instance = tempInstance;
        }

        return instance;
    }


    public void doSomething(){
        log.info("{}，doSomething", this.getClass().getCanonicalName());
    }

}
