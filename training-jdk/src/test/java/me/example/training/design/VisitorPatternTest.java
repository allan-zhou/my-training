package me.example.training.design;

import lombok.extern.slf4j.Slf4j;
import me.example.training.design.visitor.*;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 参考链接
 * https://juejin.im/entry/5ab4c3d65188251fc3293550
 * https://zh.wikipedia.org/wiki/%E8%AE%BF%E9%97%AE%E8%80%85%E6%A8%A1%E5%BC%8F
 * https://www.runoob.com/design-pattern/visitor-pattern.html
 *
 * - 意图：将数据结构和算法（数据操作）分离
 *
 * 访问者模式的结构，5个角色
 * - Visitor（访问者）：一个接口，拥有一个 visit 方法，对访问到不同类型元素做出不同反应
 * - ConcreteVisitor（具体访问者）：
 * - Element（抽象元素）：抽象类或接口，定义一个 accept 方法
 * - ConcreteElement（具体元素）：
 * - ObjectStructure（对象结构）：
 *
 * @Description: 访问者模式（visitor pattern）
 * @Author: zhoujialiang9
 * @Date: 2020/4/8 10:20
 */
@Slf4j
@SpringBootTest
public class VisitorPatternTest {

    @Test
    public void VisitorPatternTest_1(){
        HouseThing houseThing = new HouseThing();
        houseThing.addThing(HouseTv.builder().brand("小米").build());
        houseThing.addThing(HouseCouch.builder().color("浅蓝色").build());
        houseThing.addThing(HouseDiningTable.builder().style("现代简约").build());

        HouseVisitor visitor = CityVisitor.builder().name("刘德华").build();
        houseThing.feel(visitor);

        HouseVisitor visitor2 = TownVisitor.builder().name("孬蛋").build();
        houseThing.feel(visitor2);
    }
}
