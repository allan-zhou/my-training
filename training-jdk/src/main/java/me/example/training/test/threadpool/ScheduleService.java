package me.example.training.test.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * scheduleAtFixedRate和scheduleWithFixedDelay的区别
 *
 * 情况1：执行的task的时间，小于schedule周期性的时间，两者一样。
 * 情况2：执行的task的时间，大于schedule周期性的时间，两者不一样。scheduleWithFixedDelay是在每次task执行完成之后延迟delay数值之后再次执行。
 *
 * @see ScheduleService2
 *
 *
 * @author zhoujialiang9
 * @date 2022/4/18 10:25 PM
 **/
@Slf4j
public class ScheduleService {

    public static void main(String[] args) {

        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1, r -> {
            Thread t = new Thread(r);
            t.setName("my schedule thread");
            t.setDaemon(true);
            return t;
        });

        executorService.scheduleWithFixedDelay(new Runnable() {
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
        },  0,3, TimeUnit.SECONDS);


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
