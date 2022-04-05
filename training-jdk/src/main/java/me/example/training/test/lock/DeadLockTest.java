package me.example.training.test.lock;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhoujialiang9
 * @date 2022/4/5 11:04 PM
 **/
@Slf4j
public class DeadLockTest {

    public static void main(String[] args) {

        Object res1 = new Object();
        Object res2 = new Object();


        Runnable task1 =new Runnable() {
            @Override
            public void run() {

                try {

                    synchronized (res1) {
                        log.info(Thread.currentThread().getName() + "进入临界区res1");
                        Thread.sleep(1000);

                        synchronized (res2) {

                            log.info(Thread.currentThread().getName() + "进入临界区res2");
                            Thread.sleep(1000);
                        }

                    }


                } catch (Exception e) {

                }


            }
        };

        Runnable task2 =new Runnable() {
            @Override
            public void run() {

                try {

                    synchronized (res2) {
                        log.info(Thread.currentThread().getName() + "进入临界区res2");
                        Thread.sleep(1000);

                        synchronized (res1) {

                            log.info(Thread.currentThread().getName() + "进入临界区res1");
                            Thread.sleep(1000);
                        }

                    }


                } catch (Exception e) {

                }

            }
        };


        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();


    }


}
