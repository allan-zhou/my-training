package me.example.training.basic;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import me.example.training.domain.TestUser;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * 数据结构：逻辑结构、存储结构
 * 逻辑结构种类：4种。集合、线性表、树、图
 * 存储结构种类：2种。顺序存储、链式存储
 *
 * 逻辑结构分类方式二：线性结构、非线性结构
 * 线性结构：线性表——>1、一般的线性表（单链表、双向链表、等） 2、特殊的线性表（栈、队列、字符串） 3、线性表的推广（数组、广义表）
 * 非线性结构：树结构、图结构
 * 树结构：树、二叉树
 * 图结构：有向图、无向图
 *
 * 结点（Node）：由数据域、指针域组成。
 * 单链表：node只有一个指针域。
 * 双向链表：node有两个指针域。如：LinkedList
 * 循环链表：
 *
 *
 * @author zhoujialiang9
 * @date 2022/6/20 15:45
 **/
@Slf4j
@SpringBootTest
public class ListTest {

    @Test
    public void test1(){
        List<String> extraInfoFuncPoint = new ArrayList<>();
        extraInfoFuncPoint.add("a");
        extraInfoFuncPoint.add("b");

        extraInfoFuncPoint.remove("a");

        log.info("list={}", JSON.toJSONString(extraInfoFuncPoint));
    }

    /**
     * Arraylist，
     * - 添加&删除，底层均使用到java.lang.System#arraycopy
     *
     * ### 添加数据
     * - add(E element) ，直接添加一个元素
     * - add(int index, E element)，按索引添加一个元素
     *
     * ## 删除数据
     * - remove(E element)
     * - remove(int index, E element)
     *
     * *** fastRemove :
     *
     * ### 更新数据，时间复杂度O(1)
     * - set(int index, E element)
     *
     */
    @Test
    public void test2(){
        // 初始化时，不给定capacity，则使用 DEFAULTCAPACITY_EMPTY_ELEMENTDATA
        ArrayList<String> stringList = new ArrayList<>();

        // 1. 计算capacity大小。 (minCapacity=size+1, old elementData.length)
        // 2.1 场景一：如果elementData=default []， minCapacity=DEFAULT_CAPACITY=10
        // 2.2 场景二：如果minCapacity < elementData.length, 则膨胀grow(minCapacity)
        // 3. 膨胀grow，默认膨胀的大小等于原大小的1.5倍。newCapacity = oldCapacity + (oldCapacity >> 1);
        // 3.1 膨胀结果，调用 Array.copyOf
        stringList.add("a");

        // 可以显式扩大容量
        stringList.ensureCapacity(16);

        // 会报错, java.lang.IndexOutOfBoundsException
        //stringList.add(2, "c");
        // 会报错, java.lang.IndexOutOfBoundsException
        //stringList.set(2, "c");

        // it's ok
        stringList.add(1, "b");
        stringList.add(2, "c");
        stringList.set(2,"cc");
        log.info("{}", stringList);

        // 先for遍历判断，命中后进行fastRemove
        stringList.remove("c");
        // 直接arraycopy
        stringList.remove(1);

        log.info("{}", stringList);
    }

    /**
     * 区别：ArrayList#add 、 ArrayList#remove
     * 区别：Arrays#copyOf、System#arraycopy ，，，[浅拷贝]
     *
     * Arrays#copyOf方法：首先会实例化new一个新的数组，然后再进行arraycopy，底层依赖方法 System#arraycopy
     * System#arraycopy方法：当新数组比旧数组小时，会报错
     *
     * add方法：使用了Arrays#copyOf，
     * remove方法：使用了System#arraycopye
     *
     */
    @Test
    public void test3(){
        String[] s1 = new String[]{"a","b","c","d","e"};

        String[] s2 = new String[0];
        // 会报错：java.lang.ArrayIndexOutOfBoundsException
        //System.arraycopy(s1,0, s2,0,s1.length);

        String[] s3 = Arrays.copyOf(s1, s1.length);
        log.info("length={}, data={}", s3.length, JSON.toJSONString(s3));

        String[] s4 = new String[s1.length];
        System.arraycopy(s1, 0, s4, 0, s1.length);
        log.info("length={}, data={}", s4.length, JSON.toJSONString(s4));
        log.info("{}", s1 == s4);

        s4[0] = "A";
        log.info("src={} dest={}", JSON.toJSONString(s1), JSON.toJSONString(s4));


        // 浅拷贝
        TestUser[] users = new TestUser[] {
                TestUser.builder().id(1).name("a").build(),
                TestUser.builder().id(2).name("b").build(),
                TestUser.builder().id(3).name("c").build(),
        };

        TestUser[] users2 = new TestUser[users.length];
        System.arraycopy(users, 0, users2, 0, users.length);

        users2[0].setName("A");
        log.info("src={} dest={}", JSON.toJSONString(users), JSON.toJSONString(users2));
    }

    /**
     * 获取、查找方法的【时间复杂度】 差异
     *
     * ArrayList：O(1)
     * LinkedList：最差场景场景需要遍历集合一半的元素
     */
    @Test
    public void test4(){
       List<String> arrayList = Arrays.asList("a","b","c","d","e");

       int index = 1;
       // 时间：O(1)
       log.info("index={}, data={}", index,  arrayList.get(index));

       index = 2;
       List<String> linkedList = new LinkedList<String>(arrayList);
       // 时间：O(2/n)，最差场景场景需要遍历集合一半的元素
       log.info("index={}, data={}", index,  linkedList.get(index));

    }

    /**
     * LinkedList实现了Deque，具有双端队列的能力
     *
     * Queue:队列，FIFO
     */
    @Test
    public void test5(){
        List<String> arrayList = Arrays.asList("a","b","c","d","e");
        LinkedList<String> linkedList = new LinkedList<>(arrayList);

        linkedList.offer("BEIJING");
        linkedList.offerFirst("start");
        linkedList.offerLast("end");

        log.info("linkedList data={}", JSON.toJSONString(linkedList));

        log.info("poll, data={}", linkedList.poll());

        log.info("linkedList data={}", JSON.toJSONString(linkedList));
    }

    /**
     * Stack ，LIFO
     */
    @Test
    public void test6(){
        Stack<String> stringStack = new Stack<>();
        stringStack.push("a");
        stringStack.push("b");

        log.info("Stack ={}", JSON.toJSONString(stringStack));

        log.info("pop data={}", stringStack.pop());

        log.info("Stack ={}", JSON.toJSONString(stringStack));
    }

    /**
     * String
     * @see StringBuilder
     * @see StringBuffer
     *
     */
    @Test
    public void test7(){
        String str = "abcABC中国";

        // 英文占1个字节。中文占3个字节。
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        log.info("str={}, byte len={}", str, bytes.length);

        // Unicode 码点
        log.info("码点个数：{} ，字符串长度：{}", str.codePoints().peek(i-> log.info("{}", i)).count(), str.length());

        char[] chars = str.toCharArray();
        Stream.of(chars).peek(i -> {
            log.info("{} {}", i, i.getClass().getCanonicalName());
        }).forEach(i->{
            log.info("element={} type={}", i, i.getClass().getCanonicalName());
        });

        // intern方法
        String str2 = new String("abcABC") + "中国";
        log.info("{}", str == str2);
        log.info("{}", str.equals(str2));
        log.info("{}", str.intern() == str2.intern());

    }

    @Test
    public void test8(){
        List<String> stringList = new ArrayList<>();

        log.info("{}", stringList.stream().limit(1).collect(Collectors.toList()));

        stringList.add("a");
        stringList.add("b");
        stringList.add("c");

        log.info("{}", stringList.stream().limit(1).collect(Collectors.toList()));
        log.info("{}", stringList.stream().limit(2).collect(Collectors.toList()));

    }


}
