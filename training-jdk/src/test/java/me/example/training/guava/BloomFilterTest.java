package me.example.training.guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhoujialiang9
 * @date 2021/9/30 16:24
 */
@Slf4j
@SpringBootTest
public class BloomFilterTest {

    @Test
    public void test1() {

        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 100000, 0.1d);
        for (int i = 0; i < 10000; i++) {
            bloomFilter.put(i);
        }


        int count = 0;
        for (int i = 0; i < 100000; i++) {
            if (bloomFilter.mightContain(i)) {
                count = count + 1;
                log.info("bloomFilter.mightContain i={}", i);
                log.info("count={}", count);
            }
        }


    }
}
