package me.example.training.test.proxy.staticproxy;

import me.example.training.test.proxy.staticproxy.ToyotaCarSaleProxy;

/**
 * @author zhoujialiang9
 * @date 2022/4/14 2:22 PM
 **/
public class MainStatic {
    public static void main(String[] args) {

        ToyotaCarSaleProxy toyotaCarSaleProxy = new ToyotaCarSaleProxy();
        toyotaCarSaleProxy.sellCar();

        // 静态代理的问题：减少静态代理对象的创建，抽象公共内容，增加复用
        // 比如：如果丰田车、本田、大众4s店的

    }
}
