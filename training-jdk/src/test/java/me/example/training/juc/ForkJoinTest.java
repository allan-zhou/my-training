package me.example.training.juc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhoujialiang9
 * @date 2023/1/13 18:38
 **/
@Slf4j
@SpringBootTest
public class ForkJoinTest {

    /**
     * 分治思想
     *
     * Input: "2-1-1".
     *
     * ((2-1)-1) = 0
     * (2-(1-1)) = 2
     *
     * Output : [0, 2]
     */
    @Test
    public void test1(){

        String str = "2-1-1";

        diffWaysToCompute(str);

    }


    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }
}
