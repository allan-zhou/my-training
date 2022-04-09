# thread

- 线程的生命周期，线程的状态：
- 多线程协作的关系：互斥、同步、通信
- 线程的调度：java使用的是抢占式
- 线程间通信：
- 线程执行顺序：join
- 线程并发问题：共享资源、同步、锁的问题

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

## 
