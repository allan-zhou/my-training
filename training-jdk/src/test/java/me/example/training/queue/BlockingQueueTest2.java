package me.example.training.queue;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhoujialiang9
 * @date 2022/3/31 5:10 PM
 **/
@Slf4j
public class BlockingQueueTest2 {

    class Producer implements Runnable {
        /**
         * queue
         */
        private final BlockingQueue queue;

        Producer(BlockingQueue q) {
            queue = q;
        }

        public void run() {
            try {
                while (true) {
                    Object result = produce();
                    queue.put(result);
                    log.info("生产: {}, queue={}", result, queue);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException ex) {

            }
        }

        Object produce() {
            return "abc";
        }
    }

    class Consumer implements Runnable {
        private final BlockingQueue queue;

        AtomicInteger atomicInteger = new AtomicInteger(0);

        Consumer(BlockingQueue q) {
            queue = q;
        }

        public void run() {
            try {
                while (true) {
                    if(queue.peek() == null) {
                        log.info("队列为空, queue ={}", queue);

                        log.info("count={}", atomicInteger.incrementAndGet());

                        if(atomicInteger.intValue() == 3) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    consume(queue.take());

                    Thread.sleep(300);
                }
            } catch (InterruptedException ex) {

                log.error("消费异常，", ex);
                log.info("isInterrupted={}",Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
                log.info("isInterrupted={}",Thread.currentThread().isInterrupted());
            }
        }

        void consume(Object x) {
            log.info("消费：{}, queue={}", x, queue);
        }
    }

    class Monitor{

        List<Thread> threads;

        public Monitor(List<Thread> threads) {
            this.threads = threads;
        }

        public void print(){

            for (Thread t : threads) {

                log.info("id={}, name={}, state={}, isInterrupted={}", t.getId(), t.getName(), t.getState(), t.isInterrupted());
            }

        }

    }

    @Test
    public void test1()  {
        try {
            BlockingQueue blockingQueue = new LinkedBlockingQueue();

            Producer producer = new Producer(blockingQueue);
            Thread t1 = new Thread(producer);
            t1.setName("producer");
            t1.start();
            Thread.sleep(4000);

            Consumer consumer = new Consumer(blockingQueue);
            Thread t2 = new Thread(consumer);
            t2.setName("consumer");
            t2.start();


            List<Thread> threads = new ArrayList<>();
            threads.add(t1);
            threads.add(t2);
            Monitor monitor = new Monitor(threads);
            while (true) {
                monitor.print();
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {

            e.printStackTrace();

        }
    }
}
