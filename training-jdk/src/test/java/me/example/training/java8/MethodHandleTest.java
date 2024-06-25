package me.example.training.java8;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.reflect.Reflection;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.lang.reflect.ReflectPermission;

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
     * @throws Throwable
     */
    @Test
    public void test1() throws Throwable {

        // 方法句柄：方法调用
        MethodHandles.Lookup l = MethodHandles.lookup();
        MethodHandle mh0 = l.findStatic(MethodHandleTest.class, "myMethod", MethodType.methodType(void.class, String.class));
        System.out.println("myMethod type: " + mh0.type());
        mh0.invokeExact("methodHandle param");

        // 反射：方法调用
        Class clazz = Class.forName("me.example.training.java8.MethodHandleTest");
        Object obj = clazz.getDeclaredConstructor().newInstance();
        Method method = clazz.getDeclaredMethod("myMethod", String.class);
        method.invoke(obj, "reflection params");

    }

    public static void myMethod(String s) {
        System.out.println("myMethod invoked: " + s);
    }

    @Test
    public void test2(){
        // 创建一个Integer对象
        Integer integerObject = 10;
        // 创建一个int数组
        int[] intArray = new int[5];
        // 创建一个String数组
        String[] stringArray = new String[3];
    }

}
