package me.example.training.design;

import lombok.extern.slf4j.Slf4j;
import me.example.training.design.factory.IShape;
import me.example.training.design.factory.ShapeFactory;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * - 意图：定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类。工厂模式，使其创建过程延迟到子类进行。
 * - 主要解决：接口选择的问题
 *
 * @Description:
 * @Author: zhoujialiang9
 * @Date: 2020/4/8 15:13
 */
@Slf4j
@SpringBootTest
public class FactoryPatternTest {
    @Test
    public void FactoryPatternTest_1(){
        IShape shape = ShapeFactory.getShape("Circle");

        shape.draw();
    }
}
