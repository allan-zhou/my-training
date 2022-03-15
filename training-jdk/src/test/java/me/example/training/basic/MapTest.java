package me.example.training.basic;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhoujialiang9
 * @date 2021/12/28 16:57
 */
@Slf4j
@SpringBootTest
public class MapTest {

    @Test
    public void test1() {
        Map<String, Object> map = new HashMap<>();
        map.put("key", "v0");

        log.info("map={}", JSON.toJSONString(map));

        map.put("key", "v");

        log.info("map={}", JSON.toJSONString(map));
    }
}
