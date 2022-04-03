package me.example.training.test.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhoujialiang9
 * @date 2022/4/2 5:47 PM
 **/
@Slf4j
public class MyWorker2 implements Runnable{

    private boolean isOdd;

    private ReentrantLock lock;
    private Condition condition;

    public MyWorker2(ReentrantLock lock, Condition condition,Boolean isOdd){
        this.lock = lock;
        this.condition = condition;
        this.isOdd = isOdd;
    }

    @Override
    public void run() {

        try {
            lock.lock();

            // 1,3,5,7,...99
            // 2,4,6,8,,,,100
            for (int i = 0; i < 50; i++) {
                condition.signal();

                // 0, 1, 2, ... 49
                int c = (i + 1) * 2 ;
                if(this.isOdd) {
                    c = c - 1;
                }
                log.info("我是线程{}, 数字：{}", Thread.currentThread().getName(), c);

                condition.await();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
