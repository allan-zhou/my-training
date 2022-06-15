package me.example.training.designpattern.proxy.jdkproxy;

import me.example.training.designpattern.proxy.staticproxy.ICarSaleService;
import me.example.training.designpattern.proxy.staticproxy.CarSaleServiceImpl;

import java.lang.reflect.Proxy;

/**
 *
 * 1、客户端需要对接口进行强制类型转换
 *
 * @author zhoujialiang9
 * @date 2022/4/14 2:27 PM
 **/
public class Main2 {

    public static void main(String[] args) {

        // 实现2个接口
        ICarSaleService ICarSaleService2 = (ICarSaleService) Proxy.newProxyInstance(
                ICarSaleService.class.getClassLoader(),
                new Class[] {ICarSaleService.class, ICarRepairService.class},
                new CarSaleInvokeHandler2(new Car4SServiceImpl())
        );
        ICarSaleService2.sellCar();

        if(ICarSaleService2 instanceof ICarRepairService) {
            ICarRepairService ICarRepairService = (ICarRepairService) ICarSaleService2;
            ICarRepairService.repairTyre();
        }


        // 获取代理类
        Class cl = Proxy.getProxyClass(
                Car4SServiceImpl.class.getClassLoader(),
                Car4SServiceImpl.class.getInterfaces());

    }
}
