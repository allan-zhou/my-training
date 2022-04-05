package me.example.training.test.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhoujialiang9
 * @date 2022/4/2 1:41 PM
 **/
@Slf4j
public class MyAdd {

    private int total = 0;

    // 方案4：原子类
    private AtomicInteger total2 = new AtomicInteger();

    // 此方案不行，volatile只能保证可见性，不能保证原子性；
    private volatile int total3 = 0;

    // 方案1：synchronized 声明
    // 方案2：手动加锁, 详见LockTest2
    // 方案3：thread join
    public int increase() {
        return total++;
    }
    public int increase2(){
        return total2.incrementAndGet();
    }

    public int increase3(){
        return total3 ++;
    }

    public int getTotal(){
        return total;
    }


    public int getTotal2() {
        return total2.get();
    }

    public int getTotal3(){
        return total3;
    }


}
