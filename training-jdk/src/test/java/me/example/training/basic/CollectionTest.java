package me.example.training.basic;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * @see Collection
 * @see java.util.Set
 * @see java.util.List
 * @see java.util.Map
 * <p>
 * ********* Set *********
 * @see Set
 * 常用操作有：
 * 1、添加元素
 * 2、是否包含给定元素
 * @see HashSet 无序；允许空元素
 * @see TreeSet 有序；不允许空元素
 * @see LinkedHashSet 继承HashSet
 *
 * 线程安全
 * Collections.synchronizedSet(new HashSet<>());
 * Collections.synchronizedSortedSet(new TreeSet<>());
 *
 * <p>
 * ********* List *********
 * @see List
 * @see ArrayList
 * @see LinkedList  同时实现了双端队列Deque
 * @see Vector     【线程安全】，功能基本等同于ArrayList，Collections.synchronizedList(new ArrayList(...));
 * <p>
 * 问题：
 * 1、什么是 fail-fast？listIterator.remove()为什么不抛这个异常？
 *
 * <p>
 * ********* Map *********
 * @see Map
 * @see HashMap
 * @see TreeMap
 * @see LinkedHashMap 继承HashMap
 *
 * 废弃的
 * @see Dictionary
 * @see Hashtable
 *
 */
@Slf4j
@SpringBootTest
public class CollectionTest {
    /**
     * HashSet
     */
    @Test
    public void setTest1() {
        Set<String> set = new HashSet<>();
        set.add("b");
        set.add("a");
        set.add("c");
        set.add("c");
        set.add(null);
        log.info("set={}, size={}", JSON.toJSONString(set), set.size());

        log.info("contains：a, 结果={}", set.contains("a"));

        for (String str : set) {
            log.info("元素：{}", str);
        }
    }

    /**
     * TreeSet
     */
    @Test
    public void setTest2() {
        Set<String> set = new TreeSet<>((o1, o2) -> {
            // 倒序
            return o2.hashCode() - o1.hashCode();
        });

        set.add("b");
        set.add("a");
        set.add("c");
        set.add("c");

        // 不能添加null元素
        // set.add(null);
        log.info("set={}, size={}", JSON.toJSONString(set), set.size());
        log.info("contains：a, 结果={}", set.contains("a"));

        for (String str : set) {
            log.info("元素：{}", str);
        }
    }

    /**
     * 线程安全的集合
     */
    @Test
    public void setTest3() {
        // set
        Collections.synchronizedSet(new HashSet<>());
        Collections.synchronizedSortedSet(new TreeSet<>());

        // list
        Collections.synchronizedList(new ArrayList<>());
        Collections.synchronizedList(new LinkedList<>());

        // map
        Collections.synchronizedMap(new HashMap<>());
    }

    /**
     * @see ArrayList  fail-fast
     */
    @Test
    public void listTest1() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        for (String str : list) {

            log.info("删除元素:{}", str);
            list.remove(str);
        }

        log.info("list size={}", list.size());
    }

    /**
     * @see ArrayList  fail-fast
     * @see LinkedList
     */
    @Test
    public void mapTest1() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        //
        //list.remove()

        ListIterator<String> listIterator = list.listIterator();
        while(listIterator.hasNext()) {
            log.info("删除元素:{}", listIterator.next());
            listIterator.remove();
        }

        log.info("list size={}", list.size());
    }

    /**
     *  集合判空
     */
    @Test
    public void emptyTest(){

        List<String> list = new ArrayList<>();

        boolean ret = CollectionUtils.isEmpty(list);

        log.info("empty={}, size={}",ret, list.size());

    }

    @Test
    public void linkedListTest(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        log.info(linkedList.get(0));

    }
}
