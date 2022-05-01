package me.example.training.test.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhoujialiang9
 * @date 2022/4/30 6:54 PM
 **/
@Slf4j
public class ScheduleService2 {

    public static void main(String[] args) {

        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1, r -> {
            Thread t = new Thread(r);
            t.setName("my schedule thread");
            t.setDaemon(true);
            return t;
        });

        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                log.info("threadName={}, do schedule task...start", Thread.currentThread().getName());

                try {
                    Thread.sleep(5000);

                    log.info("threadName={}, do schedule task...end", Thread.currentThread().getName());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },  2,2, TimeUnit.SECONDS);


        while (true) {
            try {
                Thread.sleep(4000);

                log.info("threadName={}, sleep...", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
