package me.example.training.basic;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import me.example.training.domain.Student;
import me.example.training.domain.TestUser;
import me.example.training.domain.User;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 *
 * @see java.util.HashMap
 * @see java.util.LinkedHashMap
 * @see java.util.TreeMap
 *
 *
 *
 * @author zhoujialiang9
 * @date 2021/12/28 16:57
 */
@Slf4j
@SpringBootTest
public class MapTest {

    int MAXIMUM_CAPACITY = 1 << 30;

    @Test
    public void test1(){
        log.info("tableSizeFor(0) = {}", tableSizeFor(0));

        log.info("tableSizeFor(4) = {}", tableSizeFor(10));
        log.info("tableSizeFor(4) = {}", tableSizeFor(15));
        log.info("tableSizeFor(4) = {}", tableSizeFor(16));
    }

    /**
     * 找到大于等于cap的最小的2次幂值
     * @param cap
     * @return
     */
    final int tableSizeFor(int cap) {
        int n = cap - 1;
        log.info("n={}", n);
        n |= n >>> 1;
        log.info("n={}", n);
        n |= n >>> 2;
        log.info("n={}", n);
        n |= n >>> 4;
        log.info("n={}", n);
        n |= n >>> 8;
        log.info("n={}", n);
        n |= n >>> 16;
        log.info("n={}", n);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }


    @Test
    public void test2(){
        Object obj = new Object();
        log.info("hash={}，toBinaryString={}, i={}", hash(obj), Integer.toBinaryString(hash(obj)), 15 & hash(obj));
        obj = new Object();
        log.info("hash={}，toBinaryString={}, i={}", hash(obj), Integer.toBinaryString(hash(obj)), 15 & hash(obj));

        String keyStr = "123";
        log.info("hash={}，toBinaryString={},  i={}", hash(keyStr), Integer.toBinaryString(hash(keyStr)), 15 & hash(keyStr));
    }

    static final int hash(Object key) {
        int h;
        //return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        if(key == null) {
            return 0;
        }

        int hashCode = key.hashCode();

        log.info("hashCode={}, toBinaryString={} ", hashCode, Integer.toBinaryString(hashCode));
        int temp = hashCode >>> 16;
        log.info("hashCode >>> 16, result={}, toBinaryString={}",temp, Integer.toBinaryString(temp));

        return hashCode ^ temp;

        // key=123
        // 1011111000110010
        // 0
        // 1011111000110010
        // 下标：1011111000110010 & 15（低四位为1）
    }

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

    @Test
    public void mapTest3(){

        Map<String,String> map = Collections.EMPTY_MAP;


    }

}
