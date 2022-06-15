package me.example.training.designpattern.proxy.staticproxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhoujialiang9
 * @date 2022/4/14 2:20 PM
 **/
@Slf4j
public class CarSaleServiceImpl implements ICarSaleService {

    @Override
    public void sellCar() {
        log.info("do sell car");
    }
}
