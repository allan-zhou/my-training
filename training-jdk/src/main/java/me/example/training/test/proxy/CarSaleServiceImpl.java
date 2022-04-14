package me.example.training.test.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhoujialiang9
 * @date 2022/4/14 2:20 PM
 **/
@Slf4j
public class CarSaleServiceImpl implements CarSaleService{

    @Override
    public void sellCar() {
        log.info("do sell car");
    }
}
