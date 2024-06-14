package me.example.training.java8;

import lombok.extern.slf4j.Slf4j;
import me.example.training.domain.User;
import me.example.training.export.InterfaceA;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * 接口、抽象类
 *
 * 1、接口可以多继承实现，抽象类只能单继承
 * 2、接口可以实例化，抽象类不能实例化
 * 3、设计上，抽象类是面向继承去设计的，必然要实现多态，并且从语法上抽象类不允许实例化；抽象类侧重封装沉淀公共、默认的能力。接口是函数式编程所必须的，侧重于对宿主行为能力的增强、标识。
 * 4、接口的实现和调用，可以使用匿名类、lambda表达式
 *
 *
 * 为什么接口需要 默认方法？
 * 在多个Class实现了接口InterfaceA的情况下，如果此时InterfaceA增加一个方法func2，那么原来实现了InterfaceA的类需要全部修改。
 *
 *
 * @author zhoujialiang9
 * @date 2024/6/13 10:04
 **/
@Slf4j
@SpringBootTest
public class InterfaceTest {

    @Test
    public void test1(){
        log.info("{}", InterfaceA.NUM);
        log.info("{}", InterfaceA.hello());

        String actionResult = myAction(() -> "my test action result");
        log.info("{}", actionResult);

        User user = User.builder().id(1).name("apple").build();
        Arrays.stream(user.getClass().getInterfaces()).forEach(item -> {
            log.info("item name={}", item.getName());
        });

    }

    private String myAction(InterfaceA interfaceA) {
        return interfaceA.defaultAction() + "===" ;//+ interfaceA.action();
    }

    private abstract class AbstractMyClass{
        private String name;

        public String getName(){
            return name;
        }

        private void setName(String name){
            this.name = name;
        }
    }

}
