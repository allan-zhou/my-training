package me.example.training.designpattern.proxy.jdkproxy;

import lombok.extern.slf4j.Slf4j;
import me.example.training.designpattern.proxy.staticproxy.ICarSaleService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhoujialiang9
 * @date 2022/6/13 10:42 AM
 **/
@Slf4j
public class CarSaleInvokeHandler implements InvocationHandler {

    Object carSaleService;

    public CarSaleInvokeHandler(Object carSaleService) {
        this.carSaleService = carSaleService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(proxy instanceof ICarSaleService) {

            log.info("---------------------------before sellCar()");

            Object result = method.invoke(carSaleService, args);

            log.info("---------------------------after sellCar()");

            return result;
        }

        return null;
    }

}
