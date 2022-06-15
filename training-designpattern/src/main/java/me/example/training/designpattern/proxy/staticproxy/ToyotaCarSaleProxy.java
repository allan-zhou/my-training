package me.example.training.designpattern.proxy.staticproxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhoujialiang9
 * @date 2022/4/14 2:21 PM
 **/
@Slf4j
public class ToyotaCarSaleProxy extends CarSaleServiceImpl {

    @Override
    public void sellCar() {
        log.info("-----------do sell before");
        //log.info("i am Toyota proxy.");
        //log.info("do some sale promotion");

        super.sellCar();

        log.info("-----------do sell after");
    }
}
