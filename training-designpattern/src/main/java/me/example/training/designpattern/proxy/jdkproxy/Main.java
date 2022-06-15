package me.example.training.designpattern.proxy.jdkproxy;

import me.example.training.designpattern.proxy.staticproxy.ICarSaleService;
import me.example.training.designpattern.proxy.staticproxy.CarSaleServiceImpl;

import java.lang.reflect.Proxy;

/**
 *
 * 此例是使用jdk动态代理对对静态代理的实现。
 *
 * 1、比静态代理功能更为强大，可以面向多个接口
 *
 * @author zhoujialiang9
 * @date 2022/6/13 10:30 AM
 **/
public class Main {

    public static void main(String[] args) {
        // 该设置用于输出jdk动态代理产生的类
        // System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        ICarSaleService proxy = (ICarSaleService)Proxy.newProxyInstance(Car4SServiceImpl.class.getClassLoader(),
                new Class[]{ ICarSaleService.class},
                new CarSaleInvokeHandler(new CarSaleServiceImpl()));

        proxy.sellCar();
    }
}
