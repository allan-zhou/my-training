package me.example.training.test.proxy.cglibproxy;

import me.example.training.test.proxy.Car4sServiceImpl;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author zhoujialiang9
 * @date 2022/4/14 4:24 PM
 **/
public class MainCglib {
    public static void main(String[] args) {

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Car4sServiceImpl.class);
        enhancer.setCallback(new CarSaleMethodInterceptor());


        Car4sServiceImpl car4sService = (Car4sServiceImpl)enhancer.create();

        car4sService.sellCar();
        car4sService.repairTyre();
    }
}
