package me.example.training.design;

import lombok.extern.slf4j.Slf4j;
import me.example.training.design.abstractFactory.SkinFactory;
import me.example.training.design.abstractFactory.Skin1Factory;
import me.example.training.design.abstractFactory.Skin2Factory;
import me.example.training.design.abstractFactory.SkinFactory;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 抽象工程，又称为其他工厂的工厂。围绕一个超级工厂创建其他工厂。
 *
 * @Description:
 * @Author: zhoujialiang9
 * @Date: 2020/4/8 15:22
 */
@Slf4j
@SpringBootTest
public class AbstractFactoryPatternTest {

    @Test
    public void AbstractFactoryPatternTest_1(){
        SkinFactory factory = new Skin1Factory();
        factory.getColor().fill();
        factory.getShape().draw();

        factory = new Skin2Factory();
        factory.getColor().fill();
        factory.getShape().draw();
    }

}
