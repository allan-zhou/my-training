package me.example.training.queue;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 *
 * - 双端队列
 * - 阻塞队列
 * - 有界队列、无界队列
 * - 线程安全
 * <p>
 * <p>
 * ------------------ 队列 与 双端队列
 * @see java.util.Queue 有6个方法。add/offer, remove/poll, element/peek
 * @see java.util.Deque
 *
 * <p>
 * ------------------ 阻塞队列 与 双端阻塞队列
 * @see java.util.concurrent.BlockingQueue
 * @see java.util.concurrent.BlockingDeque
 * <p>
 * 特点：
 * - 生产-消费模型
 * - 线程安全
 *
 *
 * ------------------- 区别： ArrayBlockingQueue 与 LinkedBlockingDeque
 *
 */
@Slf4j
@SpringBootTest
public class QueueTest {

    private String DefaultDateFormat = "yyyy-MM-dd HH:mm:ss";
    /**
     * 普通队列
     *
     * @see java.util.Queue
     * @see java.util.PriorityQueue  1、无界 2、非线程安全，只有这一个
     */
    @Test
    public void test1() {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        queue.offer(1);
        queue.offer(100);
        queue.offer(2);
        queue.offer(200);
        queue.offer(3);
        queue.offer(300);
        queue.offer(301);

        int len = queue.size();
        for (int i = 0; i < len; i++) {
            log.info("poll() = {}", queue.poll());
        }
    }


    /**
     * element与peek的区别
     * 相同点：都是从队列头部删除元素
     * 不同点：当队列为空时，remove会抛错误；peek不抛错误
     *
     * remove与poll的区别，与element/peek的情况类似
     *
     */
    @Test
    public void test2() {
        Queue<String> queue = new LinkedList<>();

        queue.add("a");
        queue.add("b");
        queue.add("c");
        log.info("queue = {}", queue);


        log.info("queue.remove(), item={}",  queue.remove());
        log.info("after....... queue.remove()");
        log.info("queue = {}", queue);

        log.info("queue.element(), item = {}", queue.element());
        log.info("after........ queue.element()");
        log.info("queue = {}", queue);


        queue.remove();
        queue.remove();
        log.info("**************** now queue is empty. queue={}", queue);

        try {

            log.info("queue.remove(), item={}",  queue.remove());

        } catch (Exception e) {

            log.info("queue.remove() 异常", e);
            log.info("queue.poll(), item={}",  queue.poll());
        }


        try {
            log.info("queue.element(), item = {}", queue.element());

        } catch (Exception e) {

            log.info("queue.element() 异常", e);
            log.info("queue.peek(), item={}",  queue.peek());
        }

    }

    /**
     * 阻塞队列 - 获取数据 api
     *
     */
    @Test
    public void test5() throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(10);

        log.info("poll() start = {}", DateFormatUtils.format(new Date(), DefaultDateFormat));
        log.info("poll() = {}, end = {}", arrayBlockingQueue.poll(5, TimeUnit.SECONDS), DateFormatUtils.format(new Date(), DefaultDateFormat));

        log.info("poll() start = {}", DateFormatUtils.format(new Date(), DefaultDateFormat));
        log.info("poll() = {}, end = {}", arrayBlockingQueue.poll(), DateFormatUtils.format(new Date(), DefaultDateFormat));

        log.info("take() start = {}", DateFormatUtils.format(new Date(), DefaultDateFormat));
        log.info("take() = {}, end = {}", arrayBlockingQueue.take(), DateFormatUtils.format(new Date(), DefaultDateFormat));
    }

    /**
     * 阻塞队列 - 插入数据 api
     *
     */
    @Test
    public void test6() throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(1);
        arrayBlockingQueue.add("a");

        log.info("offer() start = {}", DateFormatUtils.format(new Date(), DefaultDateFormat));
        log.info("offer() = {},  end = {}", arrayBlockingQueue.offer("123"), DateFormatUtils.format(new Date(), DefaultDateFormat));

        log.info("offer() start = {}", DateFormatUtils.format(new Date(), DefaultDateFormat));
        log.info("offer() = {},  end = {}", arrayBlockingQueue.offer("123", 5, TimeUnit.SECONDS), DateFormatUtils.format(new Date(), DefaultDateFormat));

        log.info("put() start = {}", DateFormatUtils.format(new Date(), DefaultDateFormat));
        arrayBlockingQueue.put("123");
        log.info("put() end = {}",  DateFormatUtils.format(new Date(), DefaultDateFormat));

    }
}
