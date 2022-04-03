package me.example.training.test.lock;

import lombok.extern.slf4j.Slf4j;


/**
 * @author zhoujialiang9
 * @date 2022/4/2 2:33 PM
 **/
@Slf4j
public class LockTest3 {

    public static void main(String[] args) {
        try {
            int threadNum = 3;
            int incCount = 100000; //10W

            MyAdd myAdd = new MyAdd();

            for (int i = 0; i < threadNum; i++) {

                String threadName = "thread-" + i;

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < incCount; i++) {
                            myAdd.increase();
                        }

                        log.info("{} 完成计算", Thread.currentThread().getName());
                    }
                });
                thread.setName(threadName);
                thread.start();
                log.info("{} 启动", thread.getName());

                thread.join();
                log.info("{} join", thread.getName());

            }

            log.info("total={}", myAdd.getTotal());

            log.info("差距={}", incCount * threadNum - myAdd.getTotal());

        } catch (Exception e) {

        }
    }
}
