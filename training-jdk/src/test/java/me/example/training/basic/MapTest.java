package me.example.training.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author zhoujialiang9
 * @date 2021/12/28 16:57
 */
@Slf4j
@SpringBootTest
public class MapTest {
    /**
     * put
     * putIfAbsent
     * putAll
     */
    @Test
    public void mapTest1() {
        Map<String, String> map = new HashMap<>(16);
        String key = "key1";
        String value = "";

        value = map.put(key, "aaa");
        log.info("put result={},  value={}", value, map.get(key));
        value = map.put(key, "bbb");
        log.info("put result={},  value={}", value, map.get(key));


        // 此时value=null
        value = map.putIfAbsent(key, "1");
        log.info("putIfAbsent result={},  value={}", value, map.get(key));

        // 此时value=1
        value = map.putIfAbsent(key, "2");
        log.info("putIfAbsent result={}, value={}", value, map.get(key));

        // 此时value=1
        value = map.putIfAbsent(key, "3");
        log.info("putIfAbsent result={}, value={}", value, map.get(key));
    }

    /**
     *
     * computeIfAbsent
     * computeIfPresent
     *
     */
    @Test
    public void mapTest2() {
        Map<String, String> map = new HashMap<>(16);
        String key = "key1";
        String value = "";

        value = map.computeIfAbsent(key, (k)-> k + "_999");
        log.info("computeIfAbsent result={},  value={}", value, map.get(key));

        // 不会改变
        value = map.computeIfAbsent(key, (k)-> k + "_888");
        log.info("computeIfAbsent result={},  value={}", value, map.get(key));

        // 改变
        value = map.computeIfPresent(key, (o, n)-> n + "_888");
        log.info("computeIfPresent result={},  value={}", value, map.get(key));

        // value = null
        String key2 = "key2";
        value = map.computeIfPresent(key2, (o, n)-> n + "_111");
        log.info("computeIfPresent result={},  value={}", value, map.get(key2));
    }

}
