package me.example.training.basic;

import cn.hutool.core.bean.BeanUtil;
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

        Stream.of("1.00","1.20", "1.23", "1.234", "1.239", "a").forEach(item->{

            if (NumberUtil.isNumber(item)) {

                log.info("是数值={}, 方式1={}", item, NumberUtil.decimalFormat("#.##", new BigDecimal(item)));

                log.info("是数值={}, 方式2={}", item, NumberUtil.decimalFormat("0.00", new BigDecimal(item)));
            } else {
                log.info("不是数值={}", item);
            }


            //log.info("方式2={}",  NumberUtil.decimalFormat("0.00", NumberUtil.round( new BigDecimal(item), 2).doubleValue()));
        });
    }
}
