package me.example.training.designpattern.observer;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhoujialiang9
 * @date 2022/5/1 9:19 PM
 **/
@Slf4j
public class Person implements ITrafficLightListener{

    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void action(TrafficLightType trafficLightType) {
        switch (trafficLightType) {
            case YELLOW:
                log.info(this.name + "，准备停止");
                return;
            case GREEN:
                log.info(this.name + ", 开始行走");
                return;
            case RED:
                log.info(this.name + ", 停止等待");
                return;
            default:
                return;
        }
    }
}
