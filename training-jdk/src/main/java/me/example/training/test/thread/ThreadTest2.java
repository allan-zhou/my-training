package me.example.training.test.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhoujialiang9
 * @date 2022/4/2 5:45 PM
 **/
@Slf4j
public class ThreadTest2 {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(1);
        try {
            ReentrantLock lock = new ReentrantLock();
            Condition condition = lock.newCondition();

            Thread w1 = new Thread(new MyWorker2(lock, condition, true));
            Thread w2 = new Thread(new MyWorker2(lock, condition, false));
            w1.start();
            w2.start();

            log.info("A的状态是：{}", w1.getState().name());
            log.info("B的状态是：{}", w2.getState().name());

            latch.wait();

        } catch (Exception e) {

        }

    }
}
