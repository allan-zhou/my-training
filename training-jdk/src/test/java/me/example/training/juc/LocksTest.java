package me.example.training.juc;

/**
 *
 * ----------------------------------------------------------------------------------------------------
 * --- 既然已经有了synchronized隐式锁，为什么需要显式锁？
 * java的隐式锁（synchronized）的问题：1、同步的范围限定在synchronized语句块 2、只有一个等待队列 3、当获取多个锁时，释放必须逆序
 * 显式锁
 *
 *
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
}
