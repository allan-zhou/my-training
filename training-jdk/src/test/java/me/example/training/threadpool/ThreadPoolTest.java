package me.example.training.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.*;

/**
 *
 * @see ThreadPoolExecutor
 * 
 * 内置的 4 种线程池：
 * @see Executors#newCachedThreadPool() 
 * @see Executors#newFixedThreadPool(int) 
 * @see Executors#newSingleThreadExecutor()
 * @see Executors#newScheduledThreadPool(int) 
 *
 *
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
