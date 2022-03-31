package me.example.training.java8;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


/**
 * 函数式接口（Functional Interface）就是有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
 * - 可以被隐式转换为lambda表达式
 *
 * - Function<T, R> 接受一个输入参数，返回一个结果
 * - Consumer<T>  接受一个输入参数，无返回结果
 * - Predicate<T> 接受一个输入参数，返回布尔值
 * - Supplier<T> 无参数，返回一个结果
 *
 * @Description:
 * @Author: zhoujialiang9
 * @Date: 2020/4/7 19:30
 */
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ComponentScan("me.shop")
public class FunctionalInterfaceTest {
    @Test
    public void FunctionalInterfaceTest_1() {
        Function<Integer, String> function = (x) -> {
            return "hello  " + x;
        };

        String ret = function.apply(100);

        log.info("result = {}", ret);
    }

    @Test
    public void FunctionalInterfaceTest_2() {
        Consumer<String> consumer = (x) -> {
          log.info("参数是 = {}", x);
        };

        consumer.accept("hello");
    }

    @Test
    public void FunctionalInterfaceTest_3() {
        Predicate<String> predicate = (x) -> x.equals("123");

        boolean ret = predicate.test("123");
        log.info("test ret = {}", ret);

    }

    @Test
    public void FunctionalInterfaceTest_4() {
        Supplier<String> supplier = () -> {
            return "hello";
        };
        String ret = supplier.get();
        log.info("ret = {}", ret);

        Supplier<Integer> supplier1 = () -> {
            return 100;
        };

        int ret1 = supplier1.get();
        log.info("ret1 = {}", ret1);
    }

}
