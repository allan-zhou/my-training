package me.example.training.java8;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import me.example.training.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * ## 创建方法
 * - an array
 * - an collection
 * - an I/O channel
 * - an generator function
 * <p>
 * ## 用法
 * - 中间操作（intermediate operation）：
 * - 终端操作（terminal operation）： produces a result or side-effect
 * <p>
 * <p>
 * ## 实现原理
 * <p>
 * Stream是一个来自数据源的元素队列并支持聚合操作
 * - 数据源：流的来源，可以是数值、集合、IO channel、产生器generator
 * - 元素：是特定类型的对象，形成一个队列。Stream并不会存储元素，而是按需计算。
 * - 聚合操作：类似SQL语句一样的操作，比如filter，map，reduce，find，match，sorted等
 * <p>
 * 和以前的Collection操作不同，Stream操作还有 2 个基础特征
 * - Pipelining：中间操作都会返回流对象本身。这样多个操作可以串联成一个管道，如同流式风格（fluent style）。这样做可以对操作进行优化，比如延迟执行（laziness）和短路（short-circuiting）
 * - 内部迭代：以前对集合遍历都是通过Iterator或者For-Each的方式，显式的在集合外部进行迭代。这叫做外部迭代。Stream提供了内部迭代的方式，通过访问者模式（visitor）实现
 * <p>
 * 生成流的方式
 * - stream() - 为集合创建串行流
 * - parallelStream() - 为集合创建并行流
 * <p>
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
    List<String> stringList = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");

    List<Integer> integerList = Arrays.asList(1, 3, 5, 7, 100);

    List<User> userList = new ArrayList<>();

    @Before
    public void before() {
        userList.add(buildUser(1, "zhang san"));
        userList.add(buildUser(2, "li si"));
        userList.add(buildUser(3, "wang wu "));
    }

    /**
     * 常用操作api
     */
    @Test
    public void streamTest1() {

        log.info("----------- count={}", Stream.of(1, 22, 55, 99)
                .filter(i -> i > 50)
                .peek(i -> log.info("count peek={}", i))
                .count());

        log.info("----------- min={}", Stream.of(1, 22, 55, 99)
                .peek(i -> log.info("min peek={}", i))
                .min(Comparator.comparingInt(o -> o)));

        log.info("----------- max={}", Stream.of(1, 22, 55, 99).max((o1, o2) -> o1 - o2));


        // sorted，默认正序
        // forEach， 终端操作
        Stream.of(66, 22, 55, 99)
                .sorted()
                .forEach(i -> log.info("----------- forEach={}", i));

        Stream.of(66, 22, 55, 99)
                .sorted((o1, o2) -> o2 - o1)
                .forEach(i -> log.info("----------- forEach={}", i));

        // toArray, 终端操作
        Stream.of(1, 3, 5, 7)
                .map(i -> i * 2)
                .peek(i -> log.info("map peek={}", i))
                .toArray();


        // flatmap
        Stream.of(1, 3, 5, 7)
                .flatMap(s -> Stream.of(10, 100).map(i -> i * s))
                .peek(i -> log.info("flatMap peek={}", i))
                .toArray();


        // 短路, limit
        log.info("----------- limit={}", Stream.of(66, 22, 55, 99)
                .filter(i -> i > 50)
                .peek(i -> log.info("limit peek before sorted={}", i))
                .sorted()
                .peek(i -> log.info("limit peek after sorted={}", i))
                .limit(1)
                .peek(i -> log.info("limit peek after limit={}", i))
                .toArray());


        // distinct
        Stream.of(11, 11, 22)
                .peek(i -> log.info("distinct peek before sorted={}", i))
                .distinct()
                .peek(i -> log.info("distinct peek after sorted={}", i))
                .toArray();
    }


    /**
     * 终端操作
     * <p>
     * 结果维度：1、输出一个结果  2、副作用（side effect）
     * 短路维度：1、短路 2、非短路
     */
    @Test
    public void streamTest2() {

        log.info("----------- anyMatch={}", Stream.of(1, 3, 5, 7).anyMatch(i -> i.intValue() > 1));

        log.info("----------- allMatch={}", Stream.of(1, 3, 5, 7).allMatch(i -> i.intValue() > 1));

        log.info("----------- noneMatch={}", Stream.of(1, 3, 5, 7).noneMatch(i -> i.intValue() > 99));

        log.info("----------- findAny={}", Stream.of(1, 3, 5, 7).findAny().get());
    }

    /**
     * reduce
     * <p>
     * - 三个重构方法
     */
    @Test
    public void streamTest3() {

        Optional<Integer> result = Stream.of(1, 3, 5, 7).reduce((a, b) -> a + b);
        log.info("result = {}", result.get());

        result = Stream.of(1, 3, 5, 7).reduce(Integer::sum);
        log.info("reduce result， Integer::sum = {}", result.get());

        // Sum, min, max, average, and string concatenation are all special cases of reduction. 即identity=0的场景
        // 相当于 stream.max()
        result = Stream.of(1, 3, 5, 7).reduce(Integer::max);
        log.info("reduce result， Integer::max = {}", result.get());
        result = Stream.of(1, 3, 5, 7).max(Comparator.comparing(o -> o));
        log.info("stream.max() result，= {}", result.get());

        // 相当于 stream.min
        result = Stream.of(1, 3, 5, 7).reduce(Integer::min);
        log.info("reduce result， Integer::min = {}", result.get());
        result = Stream.of(1, 3, 5, 7).min(Comparator.comparingInt(o -> o));
        log.info("stream.min() result，= {}", result.get());


        /**
         * 重载方法2
         *
         * T reduce(T identity, BinaryOperator<T> accumulator);
         *
         */
        log.info("------------重载方法2------------");
        Integer reduceResult2 = Stream.of(1, 3, 5, 7).reduce( 100, Integer::max);
        log.info("reduce result， = {}", reduceResult2);


        /**
         * 重载方法3
         * <U> U reduce(U identity,
         *                  BiFunction<U, ? super T, U> accumulator,
         *                  BinaryOperator<U> combiner);
         */
        log.info("------------重载方法3------------");
        Integer reduceResult3 = Stream.of(1, 3, 5, 7).reduce(100, (a, b) -> a + b, Integer::sum);
        log.info("reduce result， = {}", reduceResult3);
    }


    /**
     * 创建流的方式
     *
     * 1、Stream.generate()，无限流
     * 2、Stream.iterate()， 无限流
     *
     * 3、Stream.of()， 有限流
     * 4、数组/集合。 Collection.stream(), Collection.parallelStream()
     *
     *
     * 底层方法：
     * StreamSupport.stream()
     *
     * stream(Spliterator<T> spliterator, boolean parallel)
     * stream(Supplier<? extends Spliterator<T>> supplier,int characteristics, boolean parallel)
     *
     */
    @Test
    public void streamTest4() {

        Stream.generate(() ->  {
            double d = Math.random() * 100;
            return (int)d;
        }).limit(100).forEach(integer -> {
            log.info("{}", integer);
        });

        Stream.iterate(1, integer -> integer + 1).limit(100).forEach(integer -> {
            log.info("{}", integer);
        });
    }


    @Test
    public void spliteratorTest(){
        List<User> userList = new ArrayList<>();
        userList.add(User.builder().id(1).name("a").type("aaa").build());
        userList.add(User.builder().id(2).name("b").type("aaa").build());
        userList.add(User.builder().id(3).name("c").type("bbb").build());
        userList.add(User.builder().id(4).name("d").type("bbb").build());

        Map<String, List<User>> map =userList.stream().collect(Collectors.groupingBy(User::getType));

        map.entrySet().forEach(stringListEntry -> {

            log.info("key={} value={}", stringListEntry.getKey(), JSON.toJSONString(stringListEntry.getValue()));

        });

    }


    private User buildUser(Integer id, String name) {
        User user = new User();

        user.setId(id);
        user.setName(name);

        return user;
    }
}
