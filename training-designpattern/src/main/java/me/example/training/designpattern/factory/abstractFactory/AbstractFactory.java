package me.example.training.designpattern.factory.abstractFactory;

import me.example.training.designpattern.factory.IPhone;

/**
 * @author zhoujialiang9
 * @date 2022/6/9 5:23 PM
 **/
public abstract class AbstractFactory {

    abstract IPhone createPhone(Integer money);

    abstract ICamera createCamera();
}
