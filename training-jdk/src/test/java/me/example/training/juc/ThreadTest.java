package me.example.training.juc;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import me.example.training.common.MyAddTask;
import me.example.training.common.MyAddThread;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: zhoujialiang9
 * @date: 2021/5/6 17:49
 * @see Thread
 * - priority
 * - daemon
 * <p>
 * ------------ 创建线程的方法
 * 1、继承Thread
 * 2、实现接口Runable
 * 3、FutureTask
 * 4、通过线程池创建线程
 * <p>
 * ------------ 线程的状态
 * @see Thread.State
 * <p>
 * -------------- Future
 * @see Future
 * - cancel方法
 * - get方法
 */
@Slf4j
@SpringBootTest
public class ThreadTest {

    @Test
    public void test1() {
        log.info("thread info = {}", JSON.toJSONString(Thread.currentThread()));

        int total = 0;
        for (int i = 0; i < 10000; i++) {
            total++;
        }
        log.info("total={}", total);
    }

    /**
     * 创建线程的方式 - 1、继承Thread
     */
    @Test
    public void test2() throws InterruptedException {
        Thread thread = new MyAddThread(1);
        thread.start();

        Thread.sleep(10000);
    }

    /**
     * 创建线程的方式 - 2、实现接口 Runnable
     */
    @Test
    public void test3() throws InterruptedException {
        Thread thread = new Thread(new MyAddTask(1));

        log.info("thread info = {}", JSON.toJSONString(thread));
        thread.start();
        log.info("thread info = {}", JSON.toJSONString(thread));

        Thread.sleep(10000);
    }

    /**
     * 创建线程方式 - 3、通过FutureTask，携带返回结果的
     */
    @Test
    public void test4() throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);

                return "abc";
            }
        });

        Thread thread = new Thread(futureTask);
        log.info("thread info = {}", JSON.toJSONString(thread));
        thread.start();
        log.info("thread info = {}", JSON.toJSONString(thread));

        String result = futureTask.get();

        log.info("result={}", result);

    }

    /**
     * 创建线程的方式 - 4、通过线程池
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void test5() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                Thread.sleep(3000);

                log.info("thread info = {}", JSON.toJSONString(Thread.currentThread()));

                return "abc";
            }
        });

        String result = future.get();
        log.info("result={}", result);
    }


    /**
     * 线程状态测试
     * <p>
     * NEW -> RUNNABLE -> TERMINATED
     *
     * @see Thread.State
     */
    @Test
    public void test6() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setName("me.test.thread-1");

        log.info("thread info = {}", JSON.toJSONString(thread));

        thread.start(); // 启动线程

        log.info("thread info = {}", JSON.toJSONString(thread));


        while (true) {

            if (!thread.isAlive()) {
                log.info("thread info = {}", JSON.toJSONString(thread));
                break;
            }

        }
    }

    /**
     * sleep()
     * <p>
     * 调用sleep方法，线程会进入阻塞状态，RUNNABLE -> TIMED_WAITING
     *
     * @see Thread.State
     */
    @Test
    public void test7() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    log.info("开始sleep, {}", JSON.toJSONString(Thread.currentThread()));

                    Thread.sleep(3000);

                    log.info("sleep结束, {}", JSON.toJSONString(Thread.currentThread()));

                } catch (InterruptedException e) {

                    e.printStackTrace();
                    log.info("InterruptedException, thread info = {}", JSON.toJSONString(Thread.currentThread()));
                }

            }
        });
        thread.setName("me.test.thread-1");
        log.info("thread info = {}", JSON.toJSONString(thread));

        thread.start(); // 启动线程

        log.info("thread info = {}", JSON.toJSONString(thread));

        sleepThread(1000);

        log.info("thread info = {}", JSON.toJSONString(thread));

        sleepThread(3000);

        log.info("thread info = {}", JSON.toJSONString(thread));

        sleepThread(1000);
    }

    /**
     * LockSupport.parkNanos()
     * <p>
     * 调用parkNanos()方法，线程状态会进入阻塞状态，RUNNABLE -> TIMED_WAITING
     *
     * @see Thread.State
     */
    @Test
    public void test8() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("thread info = {}", JSON.toJSONString(Thread.currentThread()));

                // 1 毫秒 = 1000000 纳秒
                LockSupport.parkNanos(1000000 * 1000);

                log.info("thread info = {}", JSON.toJSONString(Thread.currentThread()));

            }
        });
        thread.setName("me.test.thread-1");
        log.info("thread info = {}", JSON.toJSONString(thread));

        thread.start(); // 启动线程

        sleepThread(800);

        log.info("thread info = {}", JSON.toJSONString(thread));

        sleepThread(800);

        log.info("thread info = {}", JSON.toJSONString(thread));
    }

    /**
     * @see Object#wait(long)
     * <p>
     * 线程状态会进入限时阻塞状态，RUNNABLE -> TIMED_WAITING
     * @see Thread.State
     */
    @Test
    public void test9() {
        Object lock = new Object();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (lock) {
                        log.info("thread info = {}", JSON.toJSONString(Thread.currentThread()));

                        lock.wait(1000);

                        log.info("thread info = {}", JSON.toJSONString(Thread.currentThread()));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.setName("me.test.thread-1");
        log.info("thread info = {}", JSON.toJSONString(thread));

        thread.start(); // 启动线程

        sleepThread(800);

        log.info("thread info = {}", JSON.toJSONString(thread));

        sleepThread(800);

        log.info("thread info = {}", JSON.toJSONString(thread));

    }

    /**
     * @see Object#wait()
     * 线程状态会进入阻塞状态，RUNNABLE -> WAITING
     *
     * 唤醒方法：notify()
     * @see  java.lang.Object#notify()
     * @see Thread.State
     */
    @Test
    public void Test10() {
        Object lock = new Object();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (lock) {
                        log.info("thread info = {}", JSON.toJSONString(Thread.currentThread()));

                        lock.wait();

                        log.info("thread info = {}", JSON.toJSONString(Thread.currentThread()));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.setName("me.test.thread-1");
        log.info("thread info = {}", JSON.toJSONString(thread));

        thread.start(); // 启动线程

        sleepThread(800);

        log.info("thread info = {}", JSON.toJSONString(thread));


        synchronized (lock) {
            if (Thread.State.WAITING.equals(thread.getState())) {
                lock.notify();

                log.info("lock.notify()");
            }
        }


        sleepThread(3000);

        log.info("thread info = {}", JSON.toJSONString(thread));
    }


    /**
     * 唤醒方法：notifyAll()
     * @see  Object#notifyAll()
     * @see Thread.State
     */
    @Test
    public void Test11() {
        Object lock = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (lock) {
                        log.info("thread info = {}", JSON.toJSONString(Thread.currentThread()));

                        lock.wait();

                        log.info("thread info = {}", JSON.toJSONString(Thread.currentThread()));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.setName("me.test.thread-1");
        log.info("thread info = {}", JSON.toJSONString(thread1));
        thread1.start(); // 启动线程

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (lock) {
                        log.info("thread info = {}", JSON.toJSONString(Thread.currentThread()));

                        lock.wait();


                        log.info("thread info = {}", JSON.toJSONString(Thread.currentThread()));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.setName("me.test.thread-2");
        log.info("thread info = {}", JSON.toJSONString(thread2));
        thread2.start(); // 启动线程

        sleepThread(800);

        log.info("thread info = {}", JSON.toJSONString(thread1));
        log.info("thread info = {}", JSON.toJSONString(thread2));

        synchronized (lock) {
            if (Thread.State.WAITING.equals(thread1.getState())) {
                lock.notifyAll(); // 唤醒所有waiting线程

                log.info("lock.notifyAll()");
            }
        }

        sleepThread(3000);
        log.info("thread info = {}", JSON.toJSONString(thread1));
        log.info("thread info = {}", JSON.toJSONString(thread2));
    }


    /**
     * BLOCKED
     * @see Thread.State
     */
    @Test
    public void Test12() {
        Object lock = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    log.info("do something 开始。。。");
                    log.info("thread info = {}", JSON.toJSONString(Thread.currentThread()));

                    sleepThread(1000);

                    log.info("do something 结束。。。");
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    log.info("do something 开始。。。");
                    log.info("thread info = {}", JSON.toJSONString(Thread.currentThread()));
                    log.info("do something 结束。。。");
                }
            }
        });
        log.info("thread info = {}", JSON.toJSONString(thread1));
        log.info("thread info = {}", JSON.toJSONString(thread2));

        thread1.start(); // 启动线程
        thread2.start(); // 启动线程

        while (true) {
            if(Thread.State.TIMED_WAITING.equals(thread1.getState())) {
                log.info("thread info = {}", JSON.toJSONString(thread1));
            }

            if(Thread.State.BLOCKED.equals(thread2.getState())) {
                log.info("thread info = {}", JSON.toJSONString(thread2));
            }

            sleepThread(200);

            if(Thread.State.TERMINATED.equals(thread1.getState())
                    && Thread.State.TERMINATED.equals(thread2.getState())) {
                log.info("thread info = {}", JSON.toJSONString(thread1));
                log.info("thread info = {}", JSON.toJSONString(thread2));
                break;
            }
        }
    }

    private void sleepThread(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}