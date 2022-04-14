package me.example.training.test.proxy.jdkproxy;

import me.example.training.test.proxy.Car4sServiceImpl;
import me.example.training.test.proxy.CarRepairService;
import me.example.training.test.proxy.CarSaleService;
import me.example.training.test.proxy.CarSaleServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @author zhoujialiang9
 * @date 2022/4/14 2:27 PM
 **/
public class MainJdk {

    public static void main(String[] args) {

        // 实现1个接口
        CarSaleService carSaleService = (CarSaleService) Proxy.newProxyInstance(
                CarSaleService.class.getClassLoader(),
                new Class[] {CarSaleService.class},
                new CarSaleInvokeHandler(new CarSaleServiceImpl())
        );
        carSaleService.sellCar();


        // 实现2个接口
        CarSaleService carSaleService2 = (CarSaleService) Proxy.newProxyInstance(
                CarSaleService.class.getClassLoader(),
                new Class[] {CarSaleService.class, CarRepairService.class},
                new CarSaleInvokeHandler(new Car4sServiceImpl())
        );
        carSaleService2.sellCar();

        if(carSaleService2 instanceof CarRepairService) {
            CarRepairService carRepairService = (CarRepairService)carSaleService2;
            carRepairService.repairTyre();
        }


        // 获取代理类
        Class cl = Proxy.getProxyClass(
                Car4sServiceImpl.class.getClassLoader(),
                Car4sServiceImpl.class.getInterfaces());

    }
}
