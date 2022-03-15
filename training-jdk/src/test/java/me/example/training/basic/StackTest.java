package me.example.training.basic;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Stack;

/**
 *
 * @see Stack
 *
 * 基本操作：（线程安全的）
 * 1、入栈
 * 2、出栈
 * 3、查看栈顶元素
 * 4、查找栈中是否存在给定元素
 *
 *
 * @author zhoujialiang9
 * @date 2021/10/14 17:09
 * @see java.util.Stack
 */
@Slf4j
@SpringBootTest
public class StackTest {

    /**
     * 1、入栈
     * 2、出栈
     * 3、查看栈顶元素
     */
    @Test
    public void test1() {
        Stack<String> strings = new Stack<>();
        // 入栈
        strings.push("a");
        strings.push("b");
        log.info("stack={}, size={}", JSON.toJSONString(strings), strings.size());
        System.out.println();

        // 查看栈顶元素，不删除
        log.info("查看栈顶元素, peek() = {}", strings.peek());
        log.info("stack={}, size={}", JSON.toJSONString(strings), strings.size());
        System.out.println();

        // 出栈
        log.info("出栈, pop() = {}", strings.pop());
        log.info("stack={}, size={}", JSON.toJSONString(strings), strings.size());
    }

    /**
     * 查找栈中的元素
     * 方法：java.util.Stack#search(java.lang.Object)
     */
    @Test
    public void test2() {
        Stack<String> strings = new Stack<>();
        // 入栈
        strings.push("a");
        strings.push("b");
        log.info("stack={}, size={}", JSON.toJSONString(strings), strings.size());
        System.out.println();

        // 待查找元素。。。
        String[] arr = new String[]{"a", "b", "c"};

        for (int i = 0; i < arr.length; i++) {
            log.info("查找元素：{}，结果：{}", arr[i], strings.search(arr[i]));
        }
    }
}
