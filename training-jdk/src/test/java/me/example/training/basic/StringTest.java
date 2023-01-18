package me.example.training.basic;

import cn.hutool.core.codec.Base64;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhoujialiang9
 * @date 2022/7/13 17:14
 **/
@Slf4j
@SpringBootTest
public class StringTest {

    @Test
    public void test1(){

        List<String> stringList = new ArrayList<>();
        stringList.add("ABC&% + /a");


        List<String> stringList2 = stringList.stream().map(item->{
            log.info("encode       ={}", Base64.encode(item));
            log.info("encodeUrlSafe={}", Base64.encodeUrlSafe(item));
            log.info("===========");
            return Base64.encodeUrlSafe(item);
        }).collect(Collectors.toList());


        stringList2.forEach(item->{
            log.info("decodeStr={}", Base64.decodeStr(item));
        });
    }
}
