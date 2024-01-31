package me.example.training.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


/**
 * @author zhoujialiang9
 * @date 2022/6/16 2:57 PM
 **/
@Slf4j
@SpringBootTest
public class OptionalTest {
    @Test
    public void test1() {
        String str = null;
        String result = Optional.ofNullable(str).orElse("default");
        log.info("result={}", result);

    }
}
