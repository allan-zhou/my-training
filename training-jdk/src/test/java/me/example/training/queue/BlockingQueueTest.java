package me.example.training.queue;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 *
 * 两种场景：
 * 1、阻塞：put/take
 * 2、超时阻塞：offer(e, time, unit)/poll(time, unit)
 *
 * @see java.util.concurrent.BlockingQueue
 * @author zhoujialiang9
 * @date 2022/3/31 4:21 PM
 **/
@Slf4j
@SpringBootTest
public class BlockingQueueTest {

    /**
     * @see ArrayBlockingQueue 有界队列
     *
     * add/offer的区别，与普通队列 Queue 类似。
     *
     * 1、阻塞：put
     * 2、超时阻塞：offer(e, time, unit)
     *
     */
    @Test
    public void test1(){
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(8);
        for (int i = 0; i < 8; i++) {
            blockingQueue.offer(String.valueOf(i));
        }

        log.info("blocking queue inited. q={}", blockingQueue);

        String str = "a";
        try {

            blockingQueue.add(str);

        } catch (Exception e) {

            log.info("blockingQueue.add 异常", e);

            log.info("blockingQueue.offer, item={}", str);
            boolean r = blockingQueue.offer(str);
            log.info("blockingQueue.offer, item={}, result={}", str, r);
        }

        try {
            log.info("blockingQueue.offer, start={}", System.currentTimeMillis());

            boolean r = blockingQueue.offer(str, 3, TimeUnit.SECONDS);

            log.info("blockingQueue.offer, end={}, result={}", System.currentTimeMillis(), r);

        } catch (Exception e) {
            log.error("blockingQueue.offer 异常", e);
        }

        try {
            log.info("blockingQueue.put, start={}", System.currentTimeMillis());
            // 会一直阻塞
            blockingQueue.put(str);


        } catch (InterruptedException e) {
            log.info("blockingQueue.put 异常", e);
        }

        log.info("q={}", blockingQueue);
        log.info("ending...");
    }

    /**
     *
     * @see LinkedBlockingQueue 无界队列
     *
     * remove/poll的区别：与 Queue 一样。poll不抛异常
     *
     * 1、阻塞：take
     * 2、超时阻塞：poll(time, unit)
     */
    @Test
    public void test2(){
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
        for (int i = 0; i < 10; i++) {
            blockingQueue.offer(String.valueOf(i));
        }
        log.info("queue init. q={}", blockingQueue);

        for (int i = 0; i < 10; i++) {
            blockingQueue.poll();
        }
        log.info("清空队列. q={}", blockingQueue);


        try {
            blockingQueue.remove();
        } catch (Exception e) {
            log.error("blockingQueue.remove 异常, ", e);

            log.info("blockingQueue.poll(), item={}", blockingQueue.poll());
        }


        try {
            log.info("poll, start={}", System.currentTimeMillis());

            String reuslt = blockingQueue.poll(3, TimeUnit.SECONDS);

            log.info("poll, end={}, result={}", System.currentTimeMillis(), reuslt);

        } catch (Exception e) {
            log.error("poll, 异常", e);
        }


        try {
            log.info("take, start={} ", System.currentTimeMillis());

            String result = blockingQueue.take();

        }catch (Exception e) {
            log.error("take, 异常", e);
        }

        log.info("end.");

    }
}
