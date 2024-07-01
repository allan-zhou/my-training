package me.example.training.java8;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import me.example.training.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;


/**
 *---------------------------------------------------------------------------------------------------------
 * ---OOP（面向对象）和OOF（面向函数）
 *
 * 函数式编程：是一种编程范式。范式有两层含义，是计算机编程中的一类典型的理念和风格。
 * 在编程理念上，函数式编程是以数学的思维去解决问题，关注的是表达式计算。
 * 在编程风格上，函数是一等公民，在java中是lambda表达式，替代了匿名类，使代码更简洁，可读性更好。
 * 优势：1、纯函数，无副作用 2、不可变 3、性能好（并发并行）4、高阶函数
 *
 *---------------------------------------------------------------------------------------------------------
 * lambda表达式的六种语法结构：https://cloud.tencent.com/developer/article/2234333
 * 三部分：左侧是参数列表，中间是->，右侧是处理逻辑内容
 *---------------------------------------------------------------------------------------------------------
 * lambda表达式的实现原理是什么？
 * lambda的本质是，函数式接口的实例化，替换了匿名类的实例化。但是，lambda不是语法糖，jvm新增了invokedynamic指令，来支持lambda动态调用。而匿名类，还是类的实例化，最终还是实例方法的调用。
 * lambda的实现，通过MethodHandle方法句柄（动态调用的callSite），实现方法调用。
 *---------------------------------------------------------------------------------------------------------
 * 方法句柄与反射有什么区别？
 * 方法句柄，相比反射更加轻量化、性能更高。
 *---------------------------------------------------------------------------------------------------------
 *
 * 函数式接口（Functional Interface）就是有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。可以被隐式转换为lambda表达式
 * - Function<T, R> 接受一个输入参数，返回一个结果
 * - Consumer<T>  接受一个输入参数，无返回结果
 * - Predicate<T> 接受一个输入参数，返回布尔值
 * - Supplier<T> 无参数，返回一个结果
 *
 *
 *
 * @Description:
 * @Author: zhoujialiang9
 * @Date: 2020/4/7 19:30
 */
@Slf4j
@SpringBootTest
public class FunctionalTest {

    List<User> userList = new ArrayList<>();

    @Before
    public void before(){
        userList.add(User.builder().id(12).name("Apple").build());
        userList.add(User.builder().id(14).name("Hua Wei").build());
        userList.add(User.builder().id(16).name("Xiao Mi").build());
        userList.add(User.builder().id(1).name("zhang san").build());
        userList.add(User.builder().id(3).name("li si").build());
        userList.add(User.builder().id(5).name("wang wu").build());
    }

    /**
     * Comparable，内部比较器。
     * Comparator，外部比较器。
     *
     *
     */
    @Test
    public void test1(){
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getId() - o2.getId();
            }
        });

        Collections.sort(userList, (o1, o2) -> o2.getId() - o1.getId());
        //Collections.sort(userList, Comparator.comparingInt(User::getId));

        log.info("{}", JSON.toJSONString(userList));

        List<User> list = userList.stream().sorted(Comparator.comparingInt(User::getId)).collect(Collectors.toList());

        log.info("{}", JSON.toJSONString(list));

    }

}
