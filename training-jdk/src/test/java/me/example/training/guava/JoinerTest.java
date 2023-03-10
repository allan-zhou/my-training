package me.example.training.guava;

import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhoujialiang9
 * @date 2023/2/1 17:12
 **/
@Slf4j
@SpringBootTest
public class JoinerTest {
    @Test
    public void test1() {

        String str1 = "A";
        String str2 = "B";

        log.info("{}", Joiner.on("_").join(str1, str2));
        log.info("{}", getMethodName());

    }

    private String getMethodName(){
        log.info("{}", Thread.currentThread().getStackTrace()[1].getMethodName());

        return Thread.currentThread().getStackTrace()[1].getMethodName();
    }
}
