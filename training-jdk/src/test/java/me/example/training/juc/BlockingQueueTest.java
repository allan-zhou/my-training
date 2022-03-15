package me.example.training.juc;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.LinkedBlockingQueue;
/**
 *
 *
 * @description:
 * @author: zhoujialiang9
 * @date: 2021/5/6 16:39
 */
@Slf4j
@SpringBootTest
public class BlockingQueueTest {
    /**
     * 入队
     * 方式1：queue.offer
     * 方式2：queue.add， 队列满时，会抛错
     */
    @Test
    public void QueueTest1(){
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(3);
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        log.info("queue={}, size={}", JSON.toJSONString(queue), queue.size());
    }

    /**
     * 入队
     */
    @Test
    public void QueueTest1_2(){
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(3);
        queue.add("a");
        queue.add("b");
        queue.add("c");
        log.info("queue={}, size={}", JSON.toJSONString(queue), queue.size());
        queue.add("d");
        log.info("queue={}, size={}", JSON.toJSONString(queue), queue.size());
    }

    /**
     * 出队
     * 方法1：poll
     * 方法2：remove，队列为空时会抛异常
     */
    @Test
    public void QueueTest2() {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(3);
        queue.offer("a");
        queue.offer("b");
        log.info("queue={}, size={}", JSON.toJSONString(queue), queue.size());

        for (int i = 0; i < 3; i++) {
            log.info("poll {}", queue.poll());
            log.info("queue={}", JSON.toJSONString(queue));
        }
    }

    /**
     * 出队
     */
    @Test
    public void QueueTest2_2(){
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(3);
        queue.offer("a");
        queue.offer("b");
        log.info("queue={}, size={}", JSON.toJSONString(queue), queue.size());

        for (int i = 0; i < 3; i++) {
            log.info("remove {}", queue.remove());
            log.info("queue={}", JSON.toJSONString(queue));
        }
    }

    /**
     * 取队头元素
     * 方式1：queue.peek()
     * 方式2：queue.element(), 队列为空时，会抛异常
     */
    @Test
    public void QueueTest3(){
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(3);
        queue.offer("a");
        queue.offer("b");
        log.info("queue={}, size={}", JSON.toJSONString(queue), queue.size());

        for (int i = 0; i < 3; i++) {
            log.info("peek {}", queue.peek());
            queue.poll();
            log.info("queue={}", JSON.toJSONString(queue));
        }
    }

    @Test
    public void QueueTest3_2(){
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(3);
        queue.offer("a");
        queue.offer("b");
        log.info("queue={}, size={}", JSON.toJSONString(queue), queue.size());

        for (int i = 0; i < 3; i++) {
            log.info("element {}", queue.element());
            queue.poll();
            log.info("queue={}", JSON.toJSONString(queue));
        }
    }

}
