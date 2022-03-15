package me.example.training.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhoujialiang9
 * @date 2021/10/14 11:18
 */
@Slf4j
@SpringBootTest
public class TryCatchTest {
    @Test
    public void TryCatchTest_1() {

        System.out.println(myTry("apple"));

        System.out.println(myTry("banana"));

    }

    private String myTry(String str) {
        try {

            if(str.equals("banana")) {
                throw new Exception("异常了");
            }

            return str + " success";

        } catch (Exception e) {

            return str + " error";

        } finally {

            System.out.println(str + " always done。");

        }
    }
}