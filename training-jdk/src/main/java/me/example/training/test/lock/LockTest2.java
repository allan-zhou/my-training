package me.example.training.test.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhoujialiang9
 * @date 2022/4/2 2:17 PM
 **/
@Slf4j
public class LockTest2 {

    public static void main(String[] args) {
        int threadNum = 10;
        int incCount = 100000; //10W
        CountDownLatch latch = new CountDownLatch(threadNum);
        ReentrantLock lock = new ReentrantLock();

        MyAdd myAdd = new MyAdd();
        Runnable task = () -> {
            try {
                lock.lock();
                log.info("已获取锁，{}", latch.getCount());

                for (int i = 0; i < incCount; i++) {
                    myAdd.increase();
                }
                latch.countDown();
            } finally {
                lock.unlock();
                log.info("已释放锁, {}", latch.getCount());
            }

            log.info("latch count={}", latch.getCount());
        };

        for (int i = 0; i < threadNum; i++) {
            Thread thread = new Thread(task);
            thread.start();

            log.info("thread-" + i + ", 启动");
        }

        try {
            latch.await();

            log.info("total={}", myAdd.getTotal());

            log.info("差距={}", incCount * threadNum - myAdd.getTotal());

        } catch (Exception e) {

        }
    }
}
