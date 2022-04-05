package me.example.training.test.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhoujialiang9
 * @date 2022/4/2 5:45 PM
 **/
@Slf4j
public class ThreadTest2 {

    public static void main(String[] args) {

        try {
            List<Thread> threadList = new ArrayList<>();
            ReentrantLock lock = new ReentrantLock();
            Condition condition = lock.newCondition();

            Runnable task1 = new MyWorker2(lock,condition, true, threadList);
            Thread t1 = new Thread(task1);

            Runnable task2 = new MyWorker2(lock,condition, false, threadList);
            Thread t2 = new Thread(task2);

            threadList.add(t1);
            threadList.add(t2);

            t1.start();
            t2.start();

            log.info(Thread.currentThread().getName() + "状态是：" + Thread.currentThread().getState());
            LockSupport.park(Thread.currentThread());
            log.info(Thread.currentThread().getName() + "状态是：" + Thread.currentThread().getState());

        } catch (Exception e) {

        }

    }
}
