package me.example.training.basic;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhoujialiang9
 * @date 2022/7/13 17:14
 **/
@Slf4j
@SpringBootTest
public class StringTest {

    private final static String BUSINESS_ID_PREFIX = "16-796-3121-2305-";

    @Test
    public void test1(){
        String str="16-796-3121-2305-86022";


        log.info("{}", str.substring(0, str.lastIndexOf("-") + 1).equals(BUSINESS_ID_PREFIX));

        log.info("{}", str.contains(BUSINESS_ID_PREFIX));

        log.info("{}", StringUtils.contains(str, BUSINESS_ID_PREFIX));
    }
}
