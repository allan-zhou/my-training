package me.example.training.juc;

/**
 * ------------------------- juc locks 包的接口有 3 个
 * @see java.util.concurrent.locks.Lock
 * @see java.util.concurrent.locks.ReadWriteLock
 * @see java.util.concurrent.locks.Condition
 *
 *
 *
 * ------------------------- AQS
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
