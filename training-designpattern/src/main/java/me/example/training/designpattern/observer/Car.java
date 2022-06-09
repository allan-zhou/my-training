package me.example.training.designpattern.observer;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhoujialiang9
 * @date 2022/5/1 9:18 PM
 **/
@Slf4j
public class Car implements ITrafficLightListener{

    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void action(TrafficLightType trafficLightType) {
        switch (trafficLightType) {
            case YELLOW:
                log.info(this.name + "，开始踩刹车");
                return;
            case RED:
                log.info(this.name + "，停车等待");
                return;
            case GREEN:
                log.info(this.name + ", 发动汽车。。。");
                return;
            default:
                return;
        }
    }
}
