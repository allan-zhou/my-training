package me.example.training.test.java8;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhoujialiang9
 * @date 2022/7/25 18:07
 **/
@Slf4j
public class LambdaTest {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        List<String> stringList = Arrays.asList("a", "b", "c", "d", "e");


        int[] days=new int[]{1,2,3,4,5,6,7};

        for (int i = 0; i < days.length; i++) {
            if (i>=3) {
                log.info("OK.");
                continue;
            }
            log.error("Sorry, Not support the number.");
        }

    }
}
