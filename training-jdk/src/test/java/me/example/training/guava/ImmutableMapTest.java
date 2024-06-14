package me.example.training.guava;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.NumberUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import me.example.training.domain.User;
import org.apache.commons.collections4.MapUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * 一、为什么需要ImmutableMap-why
 *
 * - ImmutableMap首先是个Map，它的出现必然能更好地完成部分Map的工作，或者能完成部分Map完成不了的工作。
 * - 翻译一下：要么比Map干的好，要么能干Map不能干的活儿。
 *
 *
 *
 * 二、什么场景下使用ImmutableMapTest-when
 *
 * 三、ImmutableMap是什么-what
 *
 * 二、ImmutableMap的实践总结-How
 *
 *
 * 参考文档：
 * Java 8系列之重新认识HashMap[https://tech.meituan.com/2016/06/24/java-hashmap.html]
 *
 *
 *
 * @author zhoujialiang9
 * @date 2024/1/30 16:27
 **/
@Slf4j
@SpringBootTest
public class ImmutableMapTest {

    @Test
    public void test1() {
        Map<String,String> map = new HashMap<>();

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();

    }

    @Test
    public void test2() {
        List<User> userList = initUserList();

        // guava：从现有的Collection对象中转化
        ImmutableMap<Integer, User> immutableMap = Maps.uniqueIndex(userList, User::getId);
        log.info("immutableMap={}", JSON.toJSONString(immutableMap));


        // hutool
        Map<Integer, User> userMap = IterUtil.toMap(userList, User::getId);
        log.info("userMap={}", JSON.toJSONString(immutableMap));

    }

    private List<User> initUserList(){
        List<User> userList = new ArrayList<>();
        User user1 = User.builder().id(1).name("张三").build();
        User user2 = User.builder().id(2).name("李四").build();
        User user3 = User.builder().id(3).name("王五").build();

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        return userList;
    }
}
