package me.example.training.common;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhoujialiang9
 * @date 2021/10/25 14:50
 */
@Slf4j
public class MyAddTask implements Runnable {

    private int originValue = 0;

    public MyAddTask(Integer originValue) {
        originValue = originValue;
    }

    @Override
    public void run() {

        int result = 0;
        for (int i = originValue; i < 100; i++) {
            result += i;
        }

        log.info("result = {}", result);
    }
}
