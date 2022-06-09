package me.example.training.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoujialiang9
 * @date 2022/5/1 6:41 PM
 **/
public class TrafficLight implements ITrafficLight {

    List<ITrafficLightListener> trafficLightListeners = new ArrayList<>();

    public void addListener(ITrafficLightListener listener) {
        trafficLightListeners.add(listener);
    }

    public void removeListener(ITrafficLightListener listener) {
        trafficLightListeners.remove(listener);
    }

    public void change(TrafficLightType trafficLightType){
        for (ITrafficLightListener listener: trafficLightListeners) {
            listener.action(trafficLightType);
        }
    }
}
