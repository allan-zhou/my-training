package me.example.training.basic;

import lombok.extern.slf4j.Slf4j;
import me.example.training.domain.TestUser;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhoujialiang9
 * @date 2022/6/20 20:56
 **/
@Slf4j
@SpringBootTest
public class ArrayTest {

    /**
     * 数组类型
     */
    @Test
    public void test1(){
        String[] arr1 = new String[]{"a","b","c","d","e"};

        // java.lang.String[]
        log.info("{}", arr1.getClass().getCanonicalName());

        Integer[] arr2 = new Integer[]{1, 2, 3};

        //java.lang.Integer[]
        log.info("{}", arr2.getClass().getCanonicalName());

        TestUser[] arr3 = new TestUser[] {
                TestUser.builder().id(1).name("a").build(),
                TestUser.builder().id(2).name("b").build(),
                TestUser.builder().id(3).name("c").build(),
        };

        // me.example.training.domain.TestUser[]
        log.info("{}", arr3.getClass().getCanonicalName());
    }
}
