package me.example.training.designpattern.proxy.jdkproxy;

import lombok.extern.slf4j.Slf4j;
import me.example.training.designpattern.proxy.staticproxy.ICarSaleService;

/**
 * @author zhoujialiang9
 * @date 2022/4/14 3:56 PM
 **/
@Slf4j
public class Car4SServiceImpl implements ICarSaleService, ICarRepairService {
    @Override
    public void repairTyre() {
        log.info("开始修轮胎");
    }

    @Override
    public void sellCar() {
        log.info("开始销售汽车");
    }
}
