package me.example.training.juc;

import org.junit.Test;

/**
 * ----------------------------------------------------------------------------------------------------
 * 锁，是计算机领域解决同步问题的一种机制和手段。
 *
 * 操作系统层面，有缓存锁、总线锁，解决共享变量、指令操作的同步。
 * 数据库层面，按锁的业务功能粒度上划分，有互斥锁、共享锁（读写锁）。按锁的数据粒度划分，有表锁、行锁
 * 应用编程层面，面向多线程场景。C语言没有内置锁机制，依赖系统调用。C++中有内置的锁同步函数和工具，支持互斥锁、递归锁、共享锁等。
 * java中，有内置的锁机制。从编写锁代码的角度划分，有隐式锁（synchronized）和显式锁（juc.locks包下的锁）
 *
 * ----------------------------------------------------------------------------------------------------
 * synchronized的用法和实现
 * 用法：可以修饰类、类方法，方法内代码块
 * 底层原理：字节码插入enterMonitor和exitMonitor指令，依赖对象监视器。java的根对象Object，包含的wait/notify/notifyAll方法，进行线程状态的控制。
 * 优点：使用简单，无需关注加锁/释放锁的逻辑，jvm也对其做了优化。
 * 缺点/局限性：粒度（业务粒度、）。1、synchronized是java内置的关键，同步范围是限定的。如果跨方法或更细粒度的控制，就无能为力了。2、synchronized是互斥锁，如果想使用读写锁也无能为力。
 *
 * ----------------------------------------------------------------------------------------------------
 * --- 既然已经有了synchronized隐式锁，为什么需要显式锁？
 * java的隐式锁（synchronized）的问题：1、同步的范围限定在synchronized语句块 2、当获取多个锁时，释放必须逆序 3、只有一个等待队列
 *
 *----------------------------------------------------------------------------------------------------
 * 锁公平和效率，是一个需要平衡的问题。
 *
 * ReentrantLock，可重入锁。
 *
 *
 * ----------------------------------------------------------------------------------------------------
 * --- juc locks 包的接口有 3 个
 * @see java.util.concurrent.locks.Lock
 * @see java.util.concurrent.locks.ReadWriteLock
 * @see java.util.concurrent.locks.Condition
 *
 *
 * ----------------------------------------------------------------------------------------------------
 * --- AQS
 * @see java.util.concurrent.locks.AbstractQueuedSynchronizer
 *
 * 1、AQS支持互斥（exclusive）和共享（shared）两种模式
 *
 * @see java.util.concurrent.locks.ReentrantLock
 *
 * ReentrantLock中的Sync重写了AQS以下 3 个方法
 * + tryRelease()
 * + tryAcquire()
 * + isHeldExclusively()
 *
 * @author zhoujialiang9
 * @date 2021/10/27 10:19
 */
public class LocksTest {

    Object lock = new Object();

    @Test
    public void test1(){

        synchronized (lock) {

        }

    }
}
