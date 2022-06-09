package me.example.training.designpattern.pubsub;

/**
 * @author zhoujialiang9
 * @date 2022/5/1 10:33 PM
 **/
public class Line1 implements ILinePublisher {

    TrafficCenter trafficCenter = new TrafficCenter();

    @Override
    public void publish(LineEvent lineEvent) {

        trafficCenter.notify(lineEvent);
    }
}
