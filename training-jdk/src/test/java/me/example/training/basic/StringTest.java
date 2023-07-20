package me.example.training.basic;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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

    List<String> stringList1 = new ArrayList<>();

    @Test
    public void test1(){

        log.info("{}", StringUtils.joinWith(",",null, null));

        stringList1.add("a");
        stringList1.add("b");

        log.info("{}", StringUtils.joinWith(",",stringList1.get(0), stringList1.get(1)));

    }
}
