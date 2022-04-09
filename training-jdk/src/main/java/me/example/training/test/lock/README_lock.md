# lock

## JDK中的锁

- synchronized：内置锁、隐式锁
- ReentrantLock：显式锁
- ReadWriteLock：？？
- StampedLock：？？
- 死锁

## 几个问题
1. 是否真的需要锁，是否需要加锁？共享资源、多线程、实现同步。 `乐观锁、悲观锁`
乐观锁：实现三高（高性能、高可用、高并发）；无锁编程； 自旋锁、偏向锁；  `CAS`
悲观锁：根据悲观的程度，可区分：共享锁、独享锁/互斥锁   `synchronized` `ReentrantLock`

2. 共享资源已被线程A加锁，当线程B去获取锁时，是否阻塞？ `synchronized`
不阻塞：自旋锁、偏向锁
阻塞：重锁

3. s、


## 死锁

