package me.example.training.test.thread;

import lombok.extern.slf4j.Slf4j;

/**
 *
 *
 * @author zhoujialiang9
 * @date 2022/4/2 3:33 PM
 **/
@Slf4j
public class MyWorker extends Thread {
    private String name;
    private boolean isOdd;

    private Object monitor;

    public MyWorker(String name, Boolean isOdd, Object monitor){
        this.name = name;
        this.isOdd = isOdd;
        this.monitor = monitor;

        log.info("worker {} 初始化", name);
    }

    @Override
    public void run() {
        try {

            synchronized (this.monitor) {
                // 1,3,5,7,...99
                // 2,4,6,8,,,,100
                for (int i = 0; i < 50; i++) {

                    this.monitor.notify();

                    // 0, 1, 2, ... 49
                    // 2, 4, 6
                    int c = (i + 1) * 2 ;

                    if(this.isOdd) {
                        c = c - 1;
                    }

                    log.info("我是线程{}, 数字：{}", name, c);

                    this.monitor.wait();
                }

            }

        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
