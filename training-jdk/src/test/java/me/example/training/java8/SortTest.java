package me.example.training.java8;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import me.example.training.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * Comparable接口：内部排序器。位于java.lang包下，类对象需要实现该接口，然后使用Collections.sort可以隐式排序。
 * Comparator接口：外部排序器。位于java.util包下，类对象无需实现该接口，使用Collections.sort可以显式排序。另外，在jdk1.8之后，Comparator接口新增了很多默认接口方法
 *
 * @author zhoujialiang9
 * @date 2024/6/20 13:52
 **/
@Slf4j
@SpringBootTest
public class SortTest {

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


    @Test
    public void test1(){

        // 使用comparator比较器
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getId() - o1.getId();
            }
        });

        log.info("{}", JSON.toJSONString(userList));

        // 使用comparable
        Collections.sort(userList);

        log.info("{}", JSON.toJSONString(userList));

        // comparator，在jdk1.8之后新增了很多默认方法，对功能进行了增强
        Collections.sort(userList, Comparator.comparingInt(User::getId));
    }


}
