package me.example.training.designpattern.pubsub;

import me.example.training.designpattern.observer.TrafficLightType;

/**
 * @author zhoujialiang9
 * @date 2022/5/1 9:59 PM
 **/
public interface ILinePublisher {
    void publish(LineEvent lineEvent);
}
