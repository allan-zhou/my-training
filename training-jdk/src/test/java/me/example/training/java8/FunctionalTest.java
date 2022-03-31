package me.example.training.java8;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Function;

/**
 * @description:
 * @author: zhoujialiang9
 * @date: 2021/4/28 16:16
 */
@Slf4j
@SpringBootTest
public class FunctionalTest {
    @Test
    public void FunctionalTest_1() {

        String result = sayHello( x -> "hello " +  x + "! " + Math.random(), "java");

        log.info("result = {}", result);

    }

    public String sayHello(Function<String, String> function, String name) {
        return function.apply(name);
    }
}
