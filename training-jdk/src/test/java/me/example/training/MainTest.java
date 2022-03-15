package me.example.training;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhoujialiang9
 * @date 2021/10/14 11:02
 */
@Slf4j
@SpringBootTest
public class MainTest {
    @Test
    public void test1() {

        Integer i = 1;

        log.info("byteValue={}", i.byteValue());
    }
}
