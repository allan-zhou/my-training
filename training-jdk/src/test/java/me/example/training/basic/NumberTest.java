package me.example.training.basic;

import cn.hutool.core.util.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author zhoujialiang9
 * @date 2022/7/19 18:00
 **/
@Slf4j
@SpringBootTest
public class NumberTest {

    @Test
    public void test1() {
//
//        Stream.of("0.9999", "0.98888", "0.99", "0.90").forEach(item->{
//            log.info("result={}", NumberUtil.decimalFormat("#.##", new BigDecimal(item), RoundingMode.DOWN));
//        });

        Stream.of("10,100", "10,99","10,89").forEach(item->{

            String[] arr = StringUtils.split(item, ",");

            BigDecimal discount = new BigDecimal(arr[0]);
            BigDecimal quota = new BigDecimal(arr[1]);

            log.info("discount={}, quota={}, 结果={}折", discount, quota, calc(discount, quota));
            log.info("");
        });

    }

    private String calc(BigDecimal discount, BigDecimal quota){

        BigDecimal div = NumberUtil.div(discount, quota, 3, RoundingMode.DOWN);
        BigDecimal bigDecimal = new BigDecimal(1)
                .subtract(div)
                .multiply(new BigDecimal(10));

        log.info("discount/quota={}", div);
        log.info("1-discount/quota={}", new BigDecimal(1).subtract(div));
        log.info("(1-discount/quota) * 10={}", bigDecimal);

        //return NumberUtil.decimalFormat("#.#", bigDecimal, RoundingMode.DOWN);

        return  NumberUtil.decimalFormat("#.#", NumberUtil.round(bigDecimal, 1, RoundingMode.DOWN).doubleValue());
    }

    @Test
    public void test2() {

        log.info("{}", Stream.of("10.0", "20.1")
                .map(i -> {
                    return  Integer.parseInt(i);
                })
                .reduce((a, b) -> {
                    log.info("a={},b={}", a,b);
                    return a + b;
                }).get().toString());
    }
}
