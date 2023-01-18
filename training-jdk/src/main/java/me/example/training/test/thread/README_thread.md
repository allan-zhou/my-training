# thread

## 线程的状态
- 6种状态： new, runnable, terminated, waiting, timed_waiting, blocked ；详见Thead类内枚举定义

## 阻塞(blocked)和等待(waiting)的区别
阻塞：使用synchronize，当前线程去获取对象锁时，而锁被其他线程占有，则当前线程阻塞；特点：使用简单、由jvm来唤醒线程、不可中断
等待：Object.wait()、Thread.join()、以及Lock和Condition。特点：语义丰富、需要等待另一个线程显式唤醒、可中断

synchronize和JUC中的Lock都实现了锁的功能，但是线程进入的状态却不一样。JUC总的Lock是使用LockSupport.pack()/unpack()来实现阻塞/唤醒的，线程进入的是等待状态。
另外，两种方式唤醒后的状态都是Runnable。

## 线程间的协作关系
- 3种：互斥、同步、通信

## 线程的生命周期
- 6种状态： new, runnable, terminated, waiting, timed_waiting, blocked ；详见Thead类内枚举定义
- 与操作系统中线程状态的差异：java中的线程状态没有ready就绪态。操作系统中的ready和running态，在java中统称为runnable
- 状态间的转换：
新建线程，new Thread，状态为：NEW，
启动线程，thread.start(), 状态为：RUNNABLE
线程执行结束，状态为：TERMINATED
阻塞状态BLOCKED: 阻塞与锁、IO阻塞
等待状态WAITING: object.wait/thread.join
限时等待状态TIMED_WAITING: sleep/object.wait(time)/thread.join(time)

## 线程的调度
- 有2种调度方式：分时、抢占式；java使用的的是抢占式

## 线程间通讯
- Object# wait/notify，依赖隐式锁/内置锁 `synchronized`，对象监视器monitor，
- Condition# await/signal，依赖显式锁 lock/unlock， 

## 为什么不推荐使用 Thread.stop、Thread.suspend 和 Thread.resume？ 
- stop
1. stop本质不安全
2. 暴力停止线程，Thread.stop会直接释放当前线程已经获取到的所有锁，使得当前线程直接进入阻塞状态

- suspend、resume
1. suspend天热容易造成死锁
2. 当线程被suspend后，它持有的锁不会释放，即其他线程不能访问这些共享资源

- 参考文档： https://zhuanlan.zhihu.com/p/386595689
