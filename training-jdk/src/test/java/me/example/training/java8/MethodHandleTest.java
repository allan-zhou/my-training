package me.example.training.java8;

import lombok.extern.slf4j.Slf4j;
import me.example.training.java8.cls.CalcObj;
import me.example.training.java8.cls.MethodHandleTypeDemo;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.function.BiFunction;

/**
 * @description:
 * @author: zhoujialiang9
 * @date: 2021/4/28 16:16
 */
@Slf4j
@SpringBootTest
public class MethodHandleTest {
    /**
     * 原文：https://xie.infoq.cn/article/6d30b8221c1a967ec32ac3b9c
     *
     * 实例方法的第一个参数是实例对象，也需包含在方法句柄类型中（对应 mh1）；
     *
     * 静态方法使用 MethodHandles.Lookup 的 findStatic 方法，实例方法使用 MethodHandles.Lookup 的 findVirtual，跟普通的方法调用字节码指令相对应（invokestatic 和 invokevirtual）；
     *
     * 通过 bindTo 绑定实例对象，产生的适配器句柄类型则不包含对象类型了（对比 mh1 和 mh2），这个方法在我们通过 invokedynamic 调用点链接到合法句柄类型时会使用到。
     *
     * MethodHandles.insertArguments 方法可以在指定位置绑定一个参数，我们可以通过它实现方法的柯里化。比如可以将 f(x, y)方法的 x 参数绑定为 3，生成另一个方法句柄 g(y) = f(x, y)，每当调用 g(y)时会先在第一个位置插入 3，再调用 f(x, y)的方法句柄。
     *
     * MethodHandles.dropArguments 可以删除指定位置的参数，生成新的方法句柄，原理同 insertArguments。
     *
     * MethodHandle.asType 则可以修改参数类型，为原方法句柄生成适配器。
     *
     * @throws Throwable
     */
    @Test
    public void test_1() throws Throwable {
        MethodHandles.Lookup l = MethodHandles.lookup();
        MethodHandle mh0 = l.findStatic(MethodHandleTypeDemo.class, "a", MethodType.methodType(void.class, String.class));
        System.out.println("mh0's type: " + mh0.type());
        mh0.invokeExact("mh0");

        MethodHandle mh1 = l.findVirtual(MethodHandleTypeDemo.class, "b", MethodType.methodType(void.class, String.class));
        System.out.println("mh1's type: " + mh1.type());
        mh1.invokeExact(new MethodHandleTypeDemo(), "mh1");

        MethodHandle mh2 = mh1.bindTo(new MethodHandleTypeDemo());
        System.out.println("mh2's type: " + mh2.type());
        mh2.invokeExact("mh2");

        MethodHandle mh3 = l.findStatic(MethodHandleTypeDemo.class, "c", MethodType.methodType(int.class, String.class, String.class));
        System.out.println("mh3's type: " + mh3.type());
        int c = (int) mh3.invokeExact("mh3-1", "mh3-2");
        System.out.println("mh3 invokeExact result: " + c);

        MethodHandle mh4 = MethodHandles.insertArguments(mh3, 0, "mh4-1");
        System.out.println("mh4's type: " + mh4.type());
        int c2 = (int) mh4.invokeExact("mh4-2");
        System.out.println("mh4 invokeExact result: " + c2);

        MethodHandle mh5 = MethodHandles.dropArguments(mh3, 1, String.class);
        System.out.println("mh5's type: " + mh5.type());
        int c3 = (int) mh5.invokeExact("mh5-1", "mh5-2", "mh5-3");
        System.out.println("mh5 invokeExact result: " + c3);

        MethodHandle mh6 = mh0.asType(MethodType.methodType(void.class, Object.class));
        System.out.println("mh6's type: " + mh6.type());
        mh6.invokeExact((Object) "mh6");
    }


}
