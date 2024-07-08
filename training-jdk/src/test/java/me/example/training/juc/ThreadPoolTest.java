package me.example.training.juc;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.*;

/**
 * ----------------------------------------------------------------------------------------------------
 * 数据库连接池：性能、稳定、监控、管理。
 * Druid连接池文档：https://github.com/alibaba/druid/wiki/Druid%E8%BF%9E%E6%8E%A5%E6%B1%A0%E4%BB%8B%E7%BB%8D
 * Druid连接池的性能关键，是LRUCache的运用，缓存了PrepareStatement。LRUCache继承了LinkedHashMap，构造函数accessOrder为true，重写了removeEldestEntry方法
 *
 * ----------------------------------------------------------------------------------------------------
 * java线程池：管理（规范化）、安全（稳定性）、开发效率、并发性能
 *
 *
 * ----------------------------------------------------------------------------------------------------
 *
 *
 *
 *
 * 为什么需要线程池？
 * 如何创建一个线程池？线程池有哪些种类？
 * 线程池的核心参数有哪些？
 * 线程池的实现原理，如何实现？
 *
 * @see ThreadPoolExecutor
 *
 * @description:
 * @author: zhoujialiang9
 * @date: 2021/4/27 17:33
 */
@Slf4j
@SpringBootTest
public class ThreadPoolTest {

    String[] names = new String[]{"java", "C", "C++"};

    ExecutorService executorService = new ThreadPoolExecutor(
            10,
            100,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(200));

    @Test
    public void ThreadPoolTest_1() throws ExecutionException, InterruptedException {
        getNameByPool(executorService);

        getNameByPool(executorService);
    }


    private void getNameByPool(ExecutorService executorService ) throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> getName();

        log.info("submit 之前 = {}", DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS"));

        Future<String> future = executorService.submit(callable);

        log.info("submit 之后 = {}", DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS"));

        String name = future.get();

        log.info("future.get = {}", DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS"));

        log.info("name = {}", name);
    }

    @Test
    public void ThreadPoolTest_2() throws ExecutionException, InterruptedException {
        log.info("执行之前时间 = {}", DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS"));

        Future<String> future = getNameByPool2(executorService, 1000);
        Future<String> future2 = getNameByPool2(executorService, 2000);

        log.info("task 2 result：{}", future2.get());
        log.info("task 1 result：{}", future.get());

        log.info("执行之后时间 = {}", DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS"));


    }

    private Future<String> getNameByPool2(ExecutorService executorService, long millis) throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> getName(millis);

        log.info("submit 之前 = {}", DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS"));

        Future<String> future = executorService.submit(callable);

        log.info("submit 之后 = {}", DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS"));

        return future;
    }


    @Test
    public void ThreadPoolTest3() throws ExecutionException, InterruptedException {
        log.info("执行之前时间 = {}", DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS"));

        log.info("执行之后时间 = {}", DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS"));
    }


    private String getName() throws InterruptedException {
        Thread.sleep(1000);

        return "ABC";
    }

    private String getName(long millis) throws InterruptedException {
        Thread.sleep(millis);

        //System.out.println(Math.random());
        System.out.println("sleep 毫秒：" + millis);

        return "ABC";
    }


}
