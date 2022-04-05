package me.example.training.test.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 *
 *
 * @author zhoujialiang9
 * @date 2022/4/2 3:33 PM
 **/
@Slf4j
public class MyWorker extends Thread {

    private boolean isOdd;

    private Object monitor;

    private List<MyWorker> workerList;

    public MyWorker(Boolean isOdd, Object monitor, List<MyWorker> workerList ){
        this.isOdd = isOdd;
        this.monitor = monitor;
        this.workerList = workerList;
        this.suspend();
    }

    @Override
    public void run() {
        try {

            synchronized (this.monitor) {
                log.info(Thread.currentThread().getName() + "获取锁");
                // 1,3,5,7,...99
                // 2,4,6,8,,,,100
                for (int i = 0; i < 50; i++) {
                    printState( "线程" + Thread.currentThread().getName() + " notify前");

                    this.monitor.notify();

                    printState("线程" + Thread.currentThread().getName() + " notify后");

                    // 0, 1, 2, ... 49
                    // 2, 4, 6
                    int c = (i + 1) * 2 ;
                    if(this.isOdd) {
                        c = c - 1;
                    }
                    log.info("我是线程{}, 数字：{}", Thread.currentThread().getName(), c);

                    if(c < 100) {
                        this.monitor.wait();
                    }

                    printState("线程" + Thread.currentThread().getName() + " wait后");
                }
            }

            log.info(Thread.currentThread().getName() + "释放锁");

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    private void printState(String str){

        for (MyWorker worker: workerList) {
            log.info("{} | 线程名字：{}, 线程状态：{}", str, worker.getName(), worker.getState());
        }

    }
}
