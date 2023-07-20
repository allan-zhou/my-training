package me.example.training.spring;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.Charset;

/**
 * @author zhoujialiang9
 * @date 2023/5/23 14:57
 **/
@Slf4j
@SpringBootTest
public class BloomFilterTest {

    @Test
    public void test1(){
        int size = 100;
        String prefix = "pin_";

        BloomFilter<String> stringBloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()),  size, 0.01d);

        // 初始化布隆过滤器
        for (int i = 0; i < size; i++) {
            stringBloomFilter.put(prefix + i);
        }

        // 使用布隆过滤器判断
        int count = 0;
        for (int i = size; i < size * 2; i++) {
            if(stringBloomFilter.mightContain(prefix + i)) {
                log.info("误判了。key={}", prefix + i);
                count++;
            }
        }

        log.info("误判总数={}", count);
    }
}
