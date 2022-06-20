package me.example.training.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

/**
 * @author zhoujialiang9
 * @date 2022/6/16 8:19 PM
 **/
@Slf4j
@SpringBootTest
public class AtomicTest {
    @Test
    public void test1() {

        int i = 100;

        AtomicInteger atomicInteger = new AtomicInteger(i);

        int a = atomicInteger.updateAndGet(operand -> operand + 1);
        log.info("{}", a);

        AtomicReference<Integer> atomicReference = new AtomicReference<>(i);

        int b = atomicReference.updateAndGet(integer -> integer + 1);
        log.info("{}", b);

    }
}
