package me.example.training.fastjson;

import com.alibaba.fastjson.parser.Feature;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * @author zhoujialiang9
 * @date 2022/6/17 10:29 AM
 **/
@Slf4j
@SpringBootTest
public class MyMain {

    /**
     * @see com.alibaba.fastjson.parser.Feature
     */
    @Test
    public void test1(){

        Feature feature = Feature.AutoCloseSource;

        log.info(" name={}, ordinal={},  mask={}", feature.name(), feature.ordinal(), feature.getMask());

        Feature[] features = new Feature[]{Feature.AllowComment, Feature.AllowArbitraryCommas ,Feature.DisableASM};

        log.info("count={}, of={}", Arrays.stream(features)
                .peek(t -> log.info(" name={}, ordinal={},  mask={}", t.name(), t.ordinal(), t.getMask()))
                .count(), Feature.of(features));

        log.info("isEnabled = {}", Feature.isEnabled(Feature.of(features), Feature.DisableASM));
    }


    @Test
    public void test99(){
        log.info("{}", 2 & 4);
        log.info("{}", 2 & 527);
        log.info("{}", 527 & 2);


        int[] array = new int[]{1, 2, 4, 8, 512};

        int value = 0;
        for (int i = 0; i < array.length; i++) {
            value |= array[i];

            log.info("i={} value={}", i, value);
        }

        int features = value;
        log.info("{}", Feature.config(features, Feature.AutoCloseSource, false));

    }
}
