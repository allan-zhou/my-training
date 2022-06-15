package me.example.training.designpattern.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉
 * @author zhoujialiang9
 * @date 2022/6/10 3:27 PM
 **/
@Slf4j
public class Singleton2 {

    /**
     * volatile关键字
     */
    private volatile static Singleton2 INSTANCE;

    private Singleton2(){
        if(INSTANCE != null) {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * double check lock
     * @return
     */
    public static Singleton2 getInstance() {
        if(INSTANCE == null) {

            synchronized (Singleton2.class) {

                if(INSTANCE == null) {

                    INSTANCE = new Singleton2();
                }
            }
        }

        return INSTANCE;
    }

    public void doSomething(){
        log.info("{}，doSomething", INSTANCE.getClass().getCanonicalName());
    }


}
