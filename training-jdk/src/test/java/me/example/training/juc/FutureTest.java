package me.example.training.juc;

import cn.hutool.core.map.MapUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * Future、Runnable 组合生成了 RunnableFuture（接口）
 * FeatureTask（类） 实现了 RunnableFuture（接口）
 *
 * @author zhoujialiang9
 * @date 2022/12/27 17:02
 **/
@Slf4j
@SpringBootTest
public class FutureTest {

    /**
     * 串行
     */
    @Test
    public void test1(){
        String skuId = "123";
        String ret1 = getSkuInfo(skuId);
        String ret2 =getPriceInfo(skuId);

        log.info("ret1={}, ret2={}", ret1, ret2);
    }

    /**
     * Futrue + 线程池
     */
    @Test
    public void test2(){

        try {
            ExecutorService executorService = Executors.newFixedThreadPool(2);

            String skuId = "123";
            Future<String> future1 = executorService.submit(()-> getSkuInfo(skuId));
            Future<String> future2 = executorService.submit(()-> getPriceInfo(skuId));

            String ret1 = future1.get();
            String ret2 = future2.get();

            log.info("ret1={}, ret2={}", ret1, ret2);

        } catch (Exception e) {

        }
    }

    /**
     * 使用 CompletableFuture
     *
     * 并行操作
     */
    @Test
    public void test3() {

        try {
            String skuId = "123";
            CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()-> getSkuInfo(skuId));
            CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(()-> getPriceInfo(skuId));

            cf1.thenAccept(result->{
                log.info("ret1={}",result);
            });


            cf2.thenAccept(result->{
                log.info("ret2={}",result);
            });

            Thread.sleep(5000);

        } catch (Exception e) {

        }
    }

    /**
     * 使用 CompletableFuture
     *
     * 串行操作
     */
    @Test
    public void test4() {

        try {

            String skuId = "123";
            CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()-> getSkuInfo(skuId));

            CompletableFuture<String> cf2 = cf1.thenApplyAsync((result1)->{
                log.info("步骤1执行完成。ret1={}", result1);

                return getPriceInfo(result1);
            });

            cf2.thenAccept(result->{
                log.info("步骤2执行完成。ret2={}", result);
            });

            Thread.sleep(5000);

        } catch (Exception e) {

        }
    }


    private String getSkuInfo(String skuId){
        try {
            log.info("开始 获取商品信息。skuId={}", skuId);

            Thread.sleep(1000);

            log.info("完成 获取商品信息。skuId={}", skuId);

            Map map = MapUtil.builder().put("skuInfo", skuId).build();

            return JSON.toJSONString(map);

        } catch (Exception e) {
            log.error("error", e);

            return null;

        }
    }

    private String getPriceInfo(String skuId){
        try {
            log.info("开始 获取价格信息。skuId={}", skuId);

            Thread.sleep(2000);

            log.info("完成 获取价格信息。skuId={}", skuId);

            Map map = MapUtil.builder().put("priceInfo", skuId).build();

            return JSON.toJSONString(map);

        } catch (Exception e) {

            log.error("error", e);

            return null;
        }
    }

}
