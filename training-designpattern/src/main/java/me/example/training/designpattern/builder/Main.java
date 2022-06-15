package me.example.training.designpattern.builder;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhoujialiang9
 * @date 2022/6/13 5:34 PM
 **/
@Slf4j
public class Main {

    public static void main(String[] args) {

        // 使用 lombok 的@Builder 注解
        Computer computer = Computer.builder()
                .cpu("ARM")
                .ram("16G")
                .display("AOC")
                .build();
        log.info("computer={}", JSON.toJSONString(computer));
    }

}
