package me.example.training.common;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhoujialiang9
 * @date 2021/10/25 14:49
 */
@Slf4j
public class MyAddThread extends Thread {

    private int originValue = 0;

    public MyAddThread(Integer originValue) {
        originValue = originValue;
        log.info("thread info = {}", JSON.toJSONString(this));
    }

    @Override
    public void run() {
        int result = 0;
        for (int i = originValue; i < 100; i++) {
            result += i;
        }

        log.info("result = {}", result);
        log.info("thread info = {}", JSON.toJSONString(this));

    }
}
