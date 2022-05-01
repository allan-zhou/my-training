package me.example.training.test.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author zhoujialiang9
 * @date 2022/4/30 7:42 PM
 **/
@Slf4j
public class ScheduleService3 {

    public static void main(String[] args) {

        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1, r -> {
            Thread t = new Thread(r);
            t.setName("my schedule thread");
            t.setDaemon(true);
            return t;
        });

        ScheduledFuture<String> scheduledFuture = executorService.schedule(new Callable<String>() {
            @Override
            public String call() {

                try {
                    log.info("threadName={}, do schedule task...start", Thread.currentThread().getName());

                    Thread.sleep(5000);

                    log.info("threadName={}, do schedule task...end", Thread.currentThread().getName());

                    return "ok";

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return null;
                }

            }
        },  2, TimeUnit.SECONDS);


        while (true) {
            try {
                log.info("threadName={}, sleep...start", Thread.currentThread().getName());

                log.info("schedule done state={}", scheduledFuture.isDone());
                if(scheduledFuture.isDone()) {
                    log.info("schedule result={}", scheduledFuture.get());
                } else {
                    log.info("schedule result={}", scheduledFuture.get());
                }

                Thread.sleep(4000);

                log.info("threadName={}, sleep...end", Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
