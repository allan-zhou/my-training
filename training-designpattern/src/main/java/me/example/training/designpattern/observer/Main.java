package me.example.training.designpattern.observer;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhoujialiang9
 * @date 2022/5/1 9:20 PM
 **/
@Slf4j
public class Main {
    public static void main(String[] args) {

        TrafficLight trafficLight = new TrafficLight();
        trafficLight.addListener(new Car("BYD"));
        trafficLight.addListener(new Person("zhang san"));

        trafficLight.change(TrafficLightType.YELLOW);
        trafficLight.change(TrafficLightType.RED);
        trafficLight.change(TrafficLightType.GREEN);
    }
}
