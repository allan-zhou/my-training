package me.example.training.basic;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * - 双端队列
 * - 阻塞队列
 * - 有界队列、无界队列
 * - 线程安全
 * <p>
 * <p>
 * ------------------ 队列 与 双端队列
 *
 * @author zhoujialiang9
 * @date 2021/10/14 17:49
 * @see java.util.Queue
 * @see java.util.Deque
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
 *
 *
 *
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
     * 双端队列
     *
     * @see Deque
     * @see java.util.LinkedList
     * @see ArrayDeque 可以作为Stack，也可以作为deque
     */
    @Test
    public void test2() {
        Deque<String> stringDeque = new LinkedList<>();
        stringDeque.offer("a");
        stringDeque.offer("b");
        stringDeque.offer("c");

        log.info("deque = {} size={}", JSON.toJSONString(stringDeque), stringDeque.size());

        stringDeque.offerFirst("1");
        stringDeque.offerLast("999");

        log.info("deque = {} size={}", JSON.toJSONString(stringDeque), stringDeque.size());


        log.info("pollFirst() = {} ", stringDeque.pollFirst());
        log.info("pollLast() = {} ", stringDeque.pollLast());

    }

    /**
     * @see ArrayDeque
     * <p>
     * 1、作为 Stack，比 Stack 快
     * 2、作为 deque，比 LinkedList 快
     */
    @Test
    public void test3() {
        ArrayDeque<String> stack = new ArrayDeque<>();

        stack.push("a");
        stack.push("b");
        stack.push("c");

        int len = stack.size();

        for (int i = 0; i < len; i++) {
            // pop 实际调用 java.util.ArrayDeque.removeFirst
            log.info("pop() = {}", stack.pop());
        }
    }

    @Test
    public void test4() {
        LinkedList<String> list = new LinkedList<>();

        list.poll();
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
