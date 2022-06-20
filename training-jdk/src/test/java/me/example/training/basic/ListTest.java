package me.example.training.basic;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import me.example.training.domain.TestUser;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zhoujialiang9
 * @date 2022/6/20 15:45
 **/
@Slf4j
@SpringBootTest
public class ListTest {

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
     * ### 更新数据，O(1)
     * - set(int index, E element)
     *
     */
    @Test
    public void test1(){
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
    public void test2(){
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
}
