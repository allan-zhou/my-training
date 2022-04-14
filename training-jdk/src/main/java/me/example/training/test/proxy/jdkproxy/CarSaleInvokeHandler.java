package me.example.training.test.proxy.jdkproxy;

import lombok.extern.slf4j.Slf4j;
import me.example.training.test.proxy.CarRepairService;
import me.example.training.test.proxy.CarSaleService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhoujialiang9
 * @date 2022/4/14 2:34 PM
 **/
@Slf4j
public class CarSaleInvokeHandler implements InvocationHandler {

    private Object service;

    public CarSaleInvokeHandler(Object carSaleService) {
        this.service = carSaleService;
    }

    /**
     *
     * @param proxy 生成的代理类实例。例： class $Proxy0 extends Proxy implements CarSaleService
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(proxy instanceof CarSaleService || proxy instanceof CarRepairService) {
            log.info("汽车4s服务");
        }

        if(method.getName().equals("sellCar")) {
            log.info("整理汽车规格资料.  class={}", proxy.getClass().getName());
        } else if(method.getName().equals("repairTyre")) {
            log.info("检查轮胎尺寸大小.  class={}", proxy.getClass().getName());
        }

        return method.invoke(service, args);
    }

}
