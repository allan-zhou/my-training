package me.example.training.queue;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhoujialiang9
 * @date 2022/3/31 3:58 PM
 **/
@Slf4j
@SpringBootTest
public class DequeTest {
    /**
     * 双端队列
     *
     * @see Deque
     * @see java.util.LinkedList
     * @see ArrayDeque 可以作为Stack，也可以作为deque
     */
    @Test
    public void test1() {
        Deque<String> stringDeque = new LinkedList<>();
        stringDeque.offer("a");
        stringDeque.offer("b");
        stringDeque.offer("c");

        log.info("deque = {} size={}", JSON.toJSONString(stringDeque), stringDeque.size());

        stringDeque.offerFirst("1");
        stringDeque.offerLast("999");

        log.info("deque = {} size={}", JSON.toJSONString(stringDeque), stringDeque.size());


        log.info("pollFirst() = {} ", stringDeque.pollFirst());
        log.info("pollLast() = {} ", stringDeque.pollLast());

    }

    /**
     * @see ArrayDeque
     * <p>
     * 1、作为 Stack，比 Stack 快
     * 2、作为 deque，比 LinkedList 快
     */
    @Test
    public void test2() {
        ArrayDeque<String> stack = new ArrayDeque<>();

        stack.push("a");
        stack.push("b");
        stack.push("c");

        int len = stack.size();

        for (int i = 0; i < len; i++) {
            // pop 实际调用 java.util.ArrayDeque.removeFirst
            log.info("pop() = {}", stack.pop());
        }
    }
}
