package me.example.training.designpattern.pubsub;

import me.example.training.designpattern.observer.ITrafficLightListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoujialiang9
 * @date 2022/5/1 9:51 PM
 **/
public class TrafficCenter {

    private List<ILinePublisher> trafficLightPublishers = new ArrayList<>();

    private List<ITrafficLightListener> tr = new ArrayList<>();

    public void addPublisher(){

    }

    public void addSubscriber(){}

    public void notify(LineEvent lineEvent) {

    }

}
