package me.example.training.test.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhoujialiang9
 * @date 2022/4/18 10:25 PM
 **/
@Slf4j
public class ScheduleService {

    public static void main(String[] args) {

        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1, r -> {
            Thread t = new Thread(r);
            t.setName("my schedule thread...");
            t.setDaemon(true);
            return t;
        });

        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                log.info("schedule...{}", Thread.currentThread().getName());
            }
        },  3,3, TimeUnit.SECONDS);


        while (true) {
            try {
                Thread.sleep(5000);

                log.info("sleep...{}", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
