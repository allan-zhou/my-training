package me.example.training;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @author zhoujialiang9
 * @date 2021/10/14 11:02
 */
@Slf4j
@SpringBootTest
public class MyMainJdkTest {
    @Test
    public void test1() {

        String str = StringUtils.joinWith("|", "cid1", "cid2", null);

        System.out.println(str);

    }


    private void printList(String str){

        System.out.println("字符串：" + str);

        List<String> list = Arrays.asList(StringUtils.split(str,"_"));

        System.out.println("数组长度：" + list.size());

        for (String item: list) {
            System.out.println(item);
        }

        System.out.println();
    }

    private void printList2(String str) {
        System.out.println("字符串：" + str);

        Arrays.stream(StringUtils.split(str, "_")).forEach(it -> {
            System.out.println(it);
        });
    }

    private void printList3(String str) {
        System.out.println("字符串：" + str);

        Stream.of(StringUtils.split(str, "_")).forEach(it -> {
            System.out.println(it);
        });

    }

}
