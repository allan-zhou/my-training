package me.example.training.hutool;

import cn.hutool.core.util.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhoujialiang9
 * @date 2024/1/31 18:38
 **/
@Slf4j
@SpringBootTest
public class NumberTest {

    @Test
    public void test1() {
        BigDecimal bigDecimal = new BigDecimal("12345.6789");

        // 默认会，四舍五入
        log.info("result={}", NumberUtil.decimalFormat("#.00", bigDecimal));
        log.info("result={}", NumberUtil.decimalFormat("#.##", bigDecimal));

        // 自定义RoundingMode
        log.info("result={}", NumberUtil.decimalFormat("#.##", bigDecimal, RoundingMode.DOWN));

    }
}
