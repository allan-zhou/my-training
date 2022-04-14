package me.example.training.test.proxy.cglibproxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhoujialiang9
 * @date 2022/4/14 5:03 PM
 **/
@Slf4j
public class CarSaleMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        log.info("汽车4s服务");

        return methodProxy.invokeSuper(o, objects);
    }
}
