package me.example.training.designpattern.proxy.cglibproxy;

import me.example.training.designpattern.proxy.jdkproxy.Car4SServiceImpl;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author zhoujialiang9
 * @date 2022/4/14 4:24 PM
 **/
public class MainCglib {
    public static void main(String[] args) {

        // 该设置用于输出cglib动态代理产生的类
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Car4SServiceImpl.class);
        enhancer.setCallback(new CarSaleMethodInterceptor());


        Car4SServiceImpl car4sService = (Car4SServiceImpl)enhancer.create();

        car4sService.sellCar();
        car4sService.repairTyre();
    }
}
