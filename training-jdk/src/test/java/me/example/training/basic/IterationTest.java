package me.example.training.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.awt.datatransfer.ClipboardOwner;
import java.util.*;

/**
 * 迭代器测试
 *
 * @author zhoujialiang9
 * @date 2022/6/8 5:01 PM
 * @see java.util.Iterator
 * @see Iterable
 **/
@Slf4j
public class IterationTest {


    @Test
    public void iterationTest1() {
        List<String> list = Arrays.asList("a", "b", "c");
        log.info("list={}", list);

        list.forEach(it -> {

            log.info("forEach, item ={}", it);

            // 会报错，调用的是AbstractList.remove(), 错误类型： UnsupportedOperationException
            //list.remove(it);
        });

        Iterator<String> stringIterator = list.iterator();

        while (stringIterator.hasNext()) {

            String s = stringIterator.next();

            log.info("Iterator, item = {}", s);

            if(s.equals("c")) {
                // 会报错，调用的是AbstractList.remove(), 错误类型： UnsupportedOperationException
                //stringIterator.remove();;
            }
        }

    }

    @Test
    public void iterationTest2() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        log.info("list={}", list);

        list.forEach(it -> {

            log.info("{}", it);

            // 会报错， ArrayList.forEach(), 错误类型： java.util.ConcurrentModificationException
            //list.remove(it);
        });

        Iterator<String> stringIterator = list.iterator();

        while (stringIterator.hasNext()) {

            String s = stringIterator.next();

            if(s.equals("c")) {
                // 会报错，调用的是AbstractList.remove(), 错误类型： UnsupportedOperationException
                stringIterator.remove();;
            }
        }

        log.info("list={}", list);
    }

}
