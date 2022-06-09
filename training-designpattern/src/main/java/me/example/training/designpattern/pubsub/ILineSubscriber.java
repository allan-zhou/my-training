package me.example.training.designpattern.pubsub;

/**
 * @author zhoujialiang9
 * @date 2022/5/1 10:17 PM
 **/
public interface ILineSubscriber {
    void subscriber(LineEvent lineEvent);
}
