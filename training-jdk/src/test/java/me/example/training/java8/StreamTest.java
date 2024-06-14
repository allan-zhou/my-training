package me.example.training.java8;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import me.example.training.domain.User;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * 流，管道，
 * 函数式编程、函数式接口、lambda
 * 有限流、无限流
 * 并行编程、ForkJoinPool
 * 集合操作：过滤、分组、收集、规约
 * 内部迭代、不可变的、延迟执行、循环合并
 * 中间操作、终端操作
 * 有状态、无状态、短路操作、非短路操作
 * 接口静态方法、默认方法、方法引用
 *
 *
 * 规约：对N个数据，符合二元结合律的操作符，生成得到(reduce减少到)一个值。如：sum、count、min、max，当然使用reduce也可以做到。
 *
 *
 *
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
    List<Integer> integerList = Arrays.asList(1, 3, 5, 7, 9);

    List<User> userList = new ArrayList<>();

    @Before
    public void before() {
        userList.add(buildUser(100, "zhang san"));
        userList.add(buildUser(2, "li si"));
        userList.add(buildUser(3, "wang wu"));
        userList.add(buildUser(11, "Apple"));
        userList.add(buildUser(12, "HuaWei"));
        userList.add(buildUser(13, "XiaoMi"));
    }

    /**
     * 常用操作api
     */
    @Test
    public void streamTest1() {

        userList.stream().filter(item -> {
            log.info("filter1 item = {}", JSON.toJSONString(item));
            return item.getId() > 5;
        }).peek(item -> {
            item.setName(item.getName() + "_AAA");
            log.info("peek item = {}", JSON.toJSONString(item));
        }).forEach(item->{
            
        });

        log.info("userList={}", JSON.toJSONString(userList));

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
     *
     * reduce，有三个重载方法
     * 1、一个入参的重载方法，返回的是Optional。
     * 2、两个、三个入参的重载方法，返回的是集合元素类型。
     *
     * ======================================================
     * ===== java8 reduce方法中的第三个参数combiner有什么作用？当stream是并行流时，会触发
     * =======================================================
     *
     *
     */
    @Test
    public void streamTest3() {

        int result = integerList.stream().reduce((a, b) -> a + b).get();
        log.info("result = {}", result);

        int result1 = integerList.stream().reduce(Integer::max).get();
        log.info("reduce result， Integer::max = {}", result1);

        int result2 = integerList.stream().reduce(1, (a, b) -> a + b);
        log.info("identity=1，result={}", result2);

        integerList.stream()
                .parallel()
                .reduce(0, (acc, n) -> {
                    log.info("accumulator。acc={}, n={}", acc, n);
                    return acc + n;
                }, (acc, n) -> {
                    log.info("combiner。acc={}, n={}", acc, n);
                    return acc + n;
                });

        //log.info("result3 ={}", result3);

    }


    /**
     * 创建流的方式
     *
     * 1、Stream.generate()，无限流
     * 2、Stream.iterate()， 无限流
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

    /**
     * 有状态、无状态、短路操作、非短路操作
     *
     * 中间操作：有状态、无状态操作，都是中间操作，返回的结果都是stream
     * 终端操作：短路操作、非短路操作，都是终端操作，返回的是结果或for-each
     *
     * 有状态：有4种：sorted，distinct，limit，skip，
     * 无状态：无状态的操作
     *
     */
    @Test
    public void streamTest5() {

        // 求和
        log.info("={}", integerList.stream().sorted().collect((Collectors.summingInt(value -> value))));
        // 求和
        log.info("={}", integerList.stream().reduce((a, b) -> a +b).get());

    }



    private User buildUser(Integer id, String name) {
        User user = new User();

        user.setId(id);
        user.setName(name);

        return user;
    }
}
