package me.example.training.java8;

import lombok.extern.slf4j.Slf4j;
import me.example.training.domain.Father;
import me.example.training.domain.Son;
import me.example.training.domain.User;
import me.example.training.export.ClassA;
import me.example.training.export.InterfaceA;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ---------------------------------------------------------------------------------------------------------
 * -- 接口、抽象类
 *
 * 1、接口可以多继承实现，抽象类只能单继承
 * 2、接口可以实例化，抽象类不能实例化
 * 3、设计上，抽象类是面向继承去设计的，必然要实现多态，并且从语法上抽象类不允许实例化；抽象类侧重封装沉淀公共、默认的能力。接口是函数式编程所必须的，侧重于对宿主行为能力的增强、标识。
 * 4、接口的实现和调用，可以使用匿名类、lambda表达式
 * 5、jvm层面，接口调用使用invokeDynamic，抽象类方法调用invokeSpecial
 *
 *---------------------------------------------------------------------------------------------------------
 * ---JVM方法调用指令，5种
 * 1、invokestatic，静态方法
 * 2、invokespecial，对象实例化、实例【私有方法】、父类方法
 * 3、invokeInterface，接口方法
 * 4、invokevirtual，调用非私有的实例方法，比如 public 和 protected，大多数方法调用属于这一种。（除以上三种之外）
 * 5、invokedynamic，动态调用
 *
 * ---------------------------------------------------------------------------------------------------------
 *
 * ---为什么接口需要 默认方法？
 * 在多个Class实现了接口InterfaceA的情况下，如果此时InterfaceA增加一个方法func2，那么原来实现了InterfaceA的类需要全部修改。
 *
 * ---------------------------------------------------------------------------------------------------------
 * ---重载和重写。。。涉及方法调用的原理，比如：静态链接、动态链接、方法分派。
 * 重载：本质是方法的静态分派。方法签名不同。方法签名包括：方法名称、参数类型、参数个数，不包括返回值类型。
 * 重写：本质是方法的动态分派。
 *
 * 静态链接：java中的静态链接与c/c++不同。c/c++中，静态链接是指在编译的过程中，把符号引用转化为直接引用。java中，静态链接是指在类加载过程中，完成方法直接引用的转化。
 * 动态链接：在运行过程中，完成方法直接引用的转化
 * 无论静态链接，还是动态链接，其结果都是方法的符号引用转化为直接引用。
 *
 * 静态分派：根据静态类型，决定方法执行的版本的分派动作。对应jvm指令invokestatic、invokespecial，另外还有final修饰的方法
 * 动态分派：根据实际类型，决定方法执行的版本的分派动作。对应jvm指令invokevirtual、invokeinterface、invokedynamic
 * 静态类型，动态类型：Human man = new Man(), Human是man的景静态类型，Man是man的动态类型。
 *---------------------------------------------------------------------------------------------------------
 *
 * 虚方法、非虚方法
 * 静态链接/静态绑定，动态链接/动态绑定
 * 方法分派
 *
 * 非虚方法：在编译期，能明确方法调用关系，把符号引用转换为直接引用。比如：静态方法、构造函数、私有方法、父类方法、final修饰的方法。final修饰的方法比较特殊，虽然是不可变方法，但是实际调用使用invokevirtual指令。
 * 虚方法：在运行期，动态确定方法调用关系。
 *---------------------------------------------------------------------------------------------------------
 * --- invokedynamic 与 invokevirtual、invokeinterface 有什么区别？
 *
 *
 *
 *
 * @author zhoujialiang9
 * @date 2024/6/13 10:04
 **/
@Slf4j
@SpringBootTest
public class InterfaceTest {
    /**
     *
     *
     */
    @Test
    public void test1(){
        User user1 = new User();
        user1.setName("banana");

        log.info("{}", InterfaceA.NUM);
        log.info("{}", InterfaceA.hello());

        String actionResult = myAction(() -> "my test action result");
        log.info("{}", actionResult);

        InterfaceA interfaceA = new ClassA();
        interfaceA.action();

    }

    /**
     * 方法分派，以下示例的输出是什么？？？
     * 1、invokevirtual，实例的非私有方法调用
     * 2、invokespecial，实例的私有方法、构造函数、父类的方法super.
     *
     *
     */
    @Test
    public void test2(){
        Father son = new Son();
        son.say();
    }

    public String myAction(InterfaceA interfaceA) {
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
