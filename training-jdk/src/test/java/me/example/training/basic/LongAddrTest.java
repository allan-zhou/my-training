package me.example.training.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.LongBinaryOperator;

/**
 *【LongAdder 解决的问题】减少热点冲突，延迟CAS操作
 *【LongAdder 目的】高并发场景，提升性能
 *
 *
 * 【LongAdder 实现原理】
 * 1、LongAdder 继承 Striped64
 * 2、两个变量
 * - base 变量：非竞态场景下，直接累加到该变量上
 * - Cell[] 数组：竞态条件下，累加个各个线程自己的槽Cell[i]中
 *
 *
 *
 * 【LongAdder的其他兄弟】
 * @see java.util.concurrent.atomic.LongAccumulator ，增强版本的 LongAddr
 * @see java.util.concurrent.atomic.DoubleAdder
 * @see java.util.concurrent.atomic.DoubleAccumulator
 *
 *
 * @author zhoujialiang9
 * @date 2023/5/24 14:55
 **/
@Slf4j
@SpringBootTest
public class LongAddrTest {

    /**
     * 【AtomicLong的问题】
     *
     *  CAS有三个问题
     * 问题1：高并发下（高竞态情况），CPU开销大，性能低。——> LongAddr
     * 问题2：原子操作一个共享变量。———> 悲观锁
     * 问题3：ABA问题。————> 版本号。
     *
     */
    @Test
    public void tes1(){
        AtomicLong atomicLong = new AtomicLong();

        // unsafe.compareAndSwapLong，unsafe.getAndAddLong
        log.info("incrementAndGet={}",  atomicLong.incrementAndGet());
        log.info("incrementAndGet={}",  atomicLong.incrementAndGet());
        log.info("get={}",  atomicLong.get());
        log.info("decrementAndGet={}",  atomicLong.decrementAndGet());
    }

    /**
     * LongAdder：
     * 1、减少热点冲突，将CAS操作延迟
     * 2、只能得到某个时刻的近似值，这也就是LongAdder并不能完全替代LongAtomic的原因之一
     */
    @Test
    public void tes2(){
        LongAdder longAdder = new LongAdder();

        longAdder.increment();
        log.info("longAdder.increment()={}", longAdder.longValue());
        longAdder.add(10);
        log.info("longAdder.increment()={}", longAdder.longValue());
    }

    /**
     * LongAccumulator 是 LongAdder 的增强。
     */
    @Test
    public void tes3(){
        LongAccumulator longAccumulator = new LongAccumulator((left, right) -> left * right, 100);
        longAccumulator.accumulate(1);

        log.info("longAccumulator.longValue()={}", longAccumulator.longValue());
    }
}
