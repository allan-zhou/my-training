package me.example.training.juc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @see ThreadTest
 *
 * @author zhoujialiang9
 * @date 2022/12/30 17:53
 **/
@Slf4j
@SpringBootTest
public class ThreadTest {

    /**
     * 线程中断
     */
    @Test
    public void test1(){

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("name={}, isInterrupted={}", Thread.currentThread().getName(), Thread.currentThread().isInterrupted());

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    log.error("isInterrupted=" + Thread.currentThread().isInterrupted(),e);
                }

                log.info("name={} completed.", Thread.currentThread().getName());
            }
        });
        thread1.setName("thread1");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("name={}, isInterrupted={}", Thread.currentThread().getName(),  Thread.currentThread().isInterrupted());

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    log.error("isInterrupted=" + Thread.currentThread().isInterrupted(),e);
                }

                log.info("name={}, isInterrupted={}", Thread.currentThread().getName(), Thread.currentThread().isInterrupted());
                log.info("name={} completed.", Thread.currentThread().getName());
                log.info("name={}, isInterrupted={}", thread1.getName(), thread1.isInterrupted());
            }
        });
        thread2.setName("thread2");
        thread2.start();
        thread1.interrupt();

        log.info("name={}, isInterrupted={}", thread1.getName(), thread1.isInterrupted());
        log.info("name={}, isInterrupted={}", thread1.getName(), thread1.isInterrupted());

        while (true) {

        }

    }

}
