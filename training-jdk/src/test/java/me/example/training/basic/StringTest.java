package me.example.training.basic;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

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

    }
}
