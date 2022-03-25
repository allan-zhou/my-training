package me.example.training.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhoujialiang9
 * @date 2021/10/14 11:18
 */
@Slf4j
@SpringBootTest
public class TryCatchTest {
    @Test
    public void test1() {
        System.out.println(tryMethod("apple"));
    }

    @Test
    public void test2(){
        System.out.println(tryMethod("banana"));
    }

    @Test
    public void test3(){
        System.out.println(tryMethod2());
    }

    /**
     *
     * 通过查看字节码：
     * 在该方法中【所有代码路径】中，共3条路径，均增加了finally代码块；
     *
     * —— 这就是为什么try-catch一定执行finally的原因
     *
     * @param str
     * @return
     */
    private String tryMethod(String str) {
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

    private String tryMethod2() {

        try {

            System.out.println("try block.");
            return "try";

        } catch (Exception e) {

            System.out.println("catch block");
        }

        // 此处代码执行不到
        System.out.println("outside block");
        return "outside.";
    }
}