package me.example.training.test.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;


/**
 * @author zhoujialiang9
 * @date 2022/4/1 9:16 PM
 **/
@Slf4j
public class LockTest {

    public static void main(String[] args) {

        int threadNum = 10;
        int incCount = 100000; //10W
        CountDownLatch latch = new CountDownLatch(threadNum);

        MyAdd myAdd = new MyAdd();
        Runnable task = () -> {
            for (int i = 0; i < incCount; i++) {
                myAdd.increase();
                myAdd.increase2();
                myAdd.increase3();
            }
            latch.countDown();

            log.info("latch count={}", latch.getCount());
        };

        for (int i = 0; i < threadNum; i++) {
            Thread thread = new Thread(task);
            thread.start();
        }

        for (int i = 0; i < threadNum; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    log.info(Thread.currentThread().getName() + "读取到的volatile的值是：{}", myAdd.getTotal3());
                }
            });
            thread.start();
        }

        try {
            latch.await();

            log.info("total = {}", myAdd.getTotal());
            log.info("差距={}", incCount * threadNum - myAdd.getTotal());

            log.info("total2 = {}", myAdd.getTotal2());
            log.info("差距={}", incCount * threadNum - myAdd.getTotal2());

            log.info("total3 = {}", myAdd.getTotal3());
            log.info("差距={}", incCount * threadNum - myAdd.getTotal3());

        } catch (Exception e) {

        }
    }
}
