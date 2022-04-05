package me.example.training.test.thread;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhoujialiang9
 * @date 2022/4/2 5:47 PM
 **/
@Slf4j
public class MyWorker2 implements Runnable{

    private boolean isOdd;

    private ReentrantLock lock;
    private Condition condition;

    /**
     * worker2List
     */
    private List<Thread> threadList;

    public MyWorker2(ReentrantLock lock, Condition condition, Boolean isOdd, List<Thread> threadList){
        this.lock = lock;
        this.condition = condition;
        this.isOdd = isOdd;
        this.threadList = threadList;
    }

    @Override
    public void run() {

        try {
            lock.lock();
            log.info(Thread.currentThread().getName() + "获取锁");

            // 1,3,5,7,...99
            // 2,4,6,8,,,,100
            for (int i = 0; i < 50; i++) {

                printThreadState(Thread.currentThread().getName() + " condition.signal前 ");

                condition.signal();

                printThreadState( Thread.currentThread().getName() + " condition.signal后 ");

                // 0, 1, 2, ... 49
                int c = (i + 1) * 2 ;
                if(this.isOdd) {
                    c = c - 1;
                }
                log.info("我是线程{}, 数字：{}", Thread.currentThread().getName(), c);

                if(c < 100) {
                    condition.await();
                }

                printThreadState(Thread.currentThread().getName() + " condition.await后 ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            log.info(Thread.currentThread().getName() + "释放锁");
        }
    }

    private void printThreadState(String prefix){

        for (Thread t : threadList) {

            log.info("{}, 线程名称：{}, 线程的状态是：{}",prefix,  t.getName(), t.getState());

        }

    }

}
