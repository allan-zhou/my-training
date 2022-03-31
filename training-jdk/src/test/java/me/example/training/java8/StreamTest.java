package me.example.training.java8;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream是一个来自数据源的元素队列并支持聚合操作
 * - 数据源：流的来源，可以是数值、集合、IO channel、产生器generator
 * - 元素：是特定类型的对象，形成一个队列。Stream并不会存储元素，而是按需计算。
 * - 聚合操作：类似SQL语句一样的操作，比如filter，map，reduce，find，match，sorted等
 *
 * 和以前的Collection操作不同，Stream操作还有 2 个基础特征
 * - Pipelining：中间操作都会返回流对象本身。这样多个操作可以串联成一个管道，如同流式风格（fluent style）。这样做可以对操作进行优化，比如延迟执行（laziness）和短路（short-circuiting）
 * - 内部迭代：以前对集合遍历都是通过Iterator或者For-Each的方式，显式的在集合外部进行迭代。这叫做外部迭代。Stream提供了内部迭代的方式，通过访问者模式（visitor）实现
 *
 * 生成流的方式
 * - stream() - 为集合创建串行流
 * - parallelStream() - 为集合创建并行流
 *
 * 集合的操作
 * - forEach，map，flatMap，filter，limit，sorted
 *
 * @Description:
 * @Author: zhoujialiang9
 * @Date: 2020/4/7 15:57
 */
@Slf4j
@SpringBootTest
public class StreamTest {
    List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");


    @Test
    public void StreamTest_1(){
        List result = strings.stream()
                .filter(it -> StringUtils.isNotBlank(it))
                .filter(it -> it.contains("a"))
                .map(it -> it + "_HELLO")
                .collect(Collectors.toList());
        log.info("filer = {}", result);
    }


    @Test
    public void StreamTest_3(){
        Stream<String> stringStream = Stream.of("b","a","c");

        stringStream.sorted().forEach(it -> {
            log.info(it.toUpperCase());
        });
    }
}
