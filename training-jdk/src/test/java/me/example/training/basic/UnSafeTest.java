package me.example.training.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.misc.Unsafe;

/**
 *
 * Unsafe是用于在实质上扩展Java语言表达能力，便于在更高层（Java层）代码里实现原本要在更低层（C层）实现的核心库功能用的。
 * 这些功能包括裸内存的申请/释放/访问，低层硬件的atomic/volatile支持，创建未初始化对象等。它原本的设计就只应该被标准库使用。
 *
 *
 * 1、【多线程同步】，CAS操作，参见JDK中原子类
 * @see Unsafe#compareAndSwapInt(java.lang.Object, long, int, int)
 * @see Unsafe#compareAndSwapLong(java.lang.Object, long, long, long)
 * @see Unsafe#compareAndSwapObject(java.lang.Object, long, java.lang.Object, java.lang.Object)
 *
 * 2、【线程的挂起和恢复】，参见JDK中LockSupport类
 * @see Unsafe#park(boolean, long)
 * @see Unsafe#unpark(java.lang.Object)
 *
 * 3、【Lambda表达式】，参见类 InnerClassLambdaMetafactory
 * @see Unsafe#defineAnonymousClass(java.lang.Class, byte[], java.lang.Object[])
 *
 *
 *
 * 【参考文档】
 * - https://www.cnblogs.com/throwable/p/9139947.html
 * - https://www.zhihu.com/question/29266773?sort=created
 *
 *
 * @author zhoujialiang9
 * @date 2023/5/24 16:20
 **/
@Slf4j
@SpringBootTest
public class UnSafeTest {

    @Test
    public void test1(){
        // 静态方法获取
        Unsafe unsafe = Unsafe.getUnsafe();
    }
}
