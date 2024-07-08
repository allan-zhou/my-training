package me.example.training.juc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ----------------------------------------------------------------------------------------------------
 * ArrayBlockingQueue
 * - 有界队列。数组大小。
 * - 有一把锁。
 * - 阻塞的实现，基于ReentrantLock和Condition（notEmpty、notFull）
 *
 * LinkedBlockingQueue
 * - 默认无界队列（Integer.MAX_VALUE），也可以是有界队列。
 * - 阻塞的实现，与ArrayBlockingQueue相同，基于ReentrantLock和Condition（notEmpty、notFull）
 * - 有两把锁。takeLock、putLock，因为是FIFO队列，支持同时队头入队、队尾出队。ReentrantLock。
 *
 *
 *
 * @see ArrayBlockingQueue
 * @see LinkedBlockingQueue
 *
 * @author zhoujialiang9
 * @date 2024/7/4 17:59
 **/
@Slf4j
public class BlockingQueueTest {

    @Test
    public void test1() throws InterruptedException {

        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(16);
        arrayBlockingQueue.add("a");
        arrayBlockingQueue.add("b");
        arrayBlockingQueue.add("c");


        int count = 0;

        for (;;) {

            String result = arrayBlockingQueue.take();

            log.info("result={}, count={}", result, count++);

        }

    }

}
