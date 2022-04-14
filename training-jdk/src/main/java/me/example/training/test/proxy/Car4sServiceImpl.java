package me.example.training.test.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhoujialiang9
 * @date 2022/4/14 3:56 PM
 **/
@Slf4j
public class Car4sServiceImpl implements CarSaleService, CarRepairService {
    @Override
    public void repairTyre() {
        log.info("开始修轮胎");
    }

    @Override
    public void sellCar() {
        log.info("开始销售汽车");
    }
}
