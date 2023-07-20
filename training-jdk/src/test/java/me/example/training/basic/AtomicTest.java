package me.example.training.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @see java.util.concurrent.atomic.AtomicBoolean
 * @see java.util.concurrent.atomic.AtomicInteger
 * @see java.util.concurrent.atomic.AtomicLong
 * @see java.util.concurrent.atomic.AtomicReference
 *
 * 带版本号的：
 * @see java.util.concurrent.atomic.AtomicStampedReference
 *
 *
 * 【背景】：并发，无锁编程，线程同步，乐观锁，非阻塞
 *
 * 【实现依赖】：sun.misc.Unsafe类的 三个方法
 *
 *   * @param o         包含要修改field的对象
 *   * @param offset    对象中某field的偏移量
 *   * @param expected  期望值
 *   * @param update    更新值
 *   * @return          true | false
 * @see Unsafe#compareAndSwapInt(java.lang.Object, long, int, int)
 * @see Unsafe#compareAndSwapLong(java.lang.Object, long, long, long)
 * @see Unsafe#compareAndSwapObject(java.lang.Object, long, java.lang.Object, java.lang.Object)
 *
 *
 * 【实现原理】：linux原子指令 cmpxchg
 *
 * 【CAS详细解释】Compare And Swap，比较并交换
 *  参数有两个：预期值、 新值，如果 "旧值"=="预期值"，则更新 "旧值"为"新值"，返回true。否则，不更新"旧值"，返回false
 *
 * 【CAS的问题】
 * 1、循环时间长，则CPU开销大。————> LongAddr
 * 2、只能操作一个共享变量的原子操作 ————> 悲观锁。
 * 3、ABA问题。（三个线程工作）——————> 解决方法；AtomicStampedReference
 *
 *
 * @author zhoujialiang9
 * @date 2022/6/16 8:19 PM
 **/
@Slf4j
@SpringBootTest
public class AtomicTest {

    /**
     * AtomicInteger
     */
    @Test
    public void test1() {
        AtomicInteger atomicInteger = new AtomicInteger();

        atomicInteger.set(100);
        log.info("incrementAndGet={}", atomicInteger.incrementAndGet());
        log.info("incrementAndGet={}", atomicInteger.incrementAndGet());
        log.info("get={}", atomicInteger.get());
        log.info("decrementAndGet={}", atomicInteger.decrementAndGet());
        log.info("compareAndSet={}", atomicInteger.compareAndSet(2,100));
        log.info("get={}", atomicInteger.get());

    }

    /**
     * AtomicReference
     */
    @Test
    public void test2() {
        AtomicReference<String> atomicReference = new AtomicReference<>();

        atomicReference.set("a");
        log.info("atomicReference.get={}", atomicReference.get());
        log.info("atomicReference.getAndSet(b)={}", atomicReference.getAndSet("b"));
        log.info("atomicReference.get={}", atomicReference.get());

        log.info("atomicReference.compareAndSet(\"b\", \"c\")={}", atomicReference.compareAndSet("b", "c"));
        log.info("atomicReference.get={}", atomicReference.get());

    }
}
