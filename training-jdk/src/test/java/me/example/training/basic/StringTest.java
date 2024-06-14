package me.example.training.basic;

import lombok.extern.slf4j.Slf4j;
import me.example.training.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author zhoujialiang9
 * @date 2022/7/13 17:14
 **/
@Slf4j
@SpringBootTest
public class StringTest {

    List<String> stringList = new ArrayList<>();

    @Test
    public void test1(){
        stringList.add("https://pro.m.jd.com/mall/active/3xhqjGH1wMz5FaMgrfYhR22sFvqz/index.html?venderId={$}");



        stringList.stream().forEach(str -> {


            log.info("{}",StringUtils.replaceChars( str, "{$}","888000"));
            log.info("{}",StringUtils.replace( str, "{$}","888000"));

        });

        String str = MessageFormat.format("hello {0}，haha {1}", "张三", "张三");
        log.info("{}", str);

    }

    @Test
    public void test2(){
        User user = new User();
        user.setName("apple");

        log.info("{}", Objects.equals(user.getId(), 1));
    }
}
