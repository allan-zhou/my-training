package me.example.training.test.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 *
 * 解题；
 * 启动两个线程, 一个输出 1,3,5,7…99, 另一个输出 2,4,6,8…100 最后 STDOUT 中按序输出 1,2,3,4,5…100
 *
 * wait/notify
 *
 * @author zhoujialiang9
 * @date 2022/4/2 3:43 PM
 **/
@Slf4j
public class ThreadTest {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(1);

        Object monitor = new Object();
        try {

            MyWorker a = new MyWorker("A", true, monitor );
            MyWorker b = new MyWorker("B", false, monitor);
            a.start();
            b.start();

            log.info("A的状态是：{}", a.getState().name());
            log.info("B的状态是：{}", b.getState().name());

            latch.await();

        } catch (Exception e) {

        }
    }

}
