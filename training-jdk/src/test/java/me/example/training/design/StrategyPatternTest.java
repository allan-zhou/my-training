package me.example.training.design;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 参考链接：
 * https://juejin.im/post/5c25b8bcf265da61117a5ea1
 * https://zh.wikipedia.org/wiki/%E7%AD%96%E7%95%A5%E6%A8%A1%E5%BC%8F
 *
 * 策略模式，指对象有某个行为，但是在不同的场景下，该行为有不同的实现算法。
 * 比如，每个人都要交“个人所得税”，但是在“美国交个人所得税”与“在中国交个人所得税”就有不同的的算法。
 *
 * - 意图：定义一组算法，将每个算法都封装起来，并且使他们之间可以互换
 * - 主要解决：在多种算法相似的情况下，使用 if...else 所带来的复杂和难以维护
 *
 * 策略模式的结构，3个角色
 * - Strategy（策略）
 * - ConcreteStrategy（具体策略）
 * - Context（上下文）
 *
 * @Description: 策略模式（strategy pattern）
 * @Author: zhoujialiang9
 * @Date: 2020/4/8 11:55
 */
@Slf4j
@SpringBootTest
public class StrategyPatternTest {

    /**
     * 策略模式 + 工厂模式，优化 if...else
     */
    @Test
    public void StrategyPatternTest_1(){

    }

    private void ifelse(){
        String condition = "";
        if(condition.equals("正常情况")) {
            // todo: 坐公交 + 换成

        } else if(condition.equals("起晚了")) {
            // todo: 坐地铁

        } else if(condition.equals("锻炼身体")) {
            // todo: 骑自行车

        } else if(condition.equals("")) {
            // todo: 步行
        }
    }
}
