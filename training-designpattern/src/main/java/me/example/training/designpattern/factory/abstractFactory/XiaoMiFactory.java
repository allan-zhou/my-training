package me.example.training.designpattern.factory.abstractFactory;

import me.example.training.designpattern.factory.IPhone;

/**
 * @author zhoujialiang9
 * @date 2022/6/9 5:26 PM
 **/
public class XiaoMiFactory extends AbstractFactory {
    @Override
    IPhone createPhone(Integer money) {
        return null;
    }

    @Override
    ICamera createCamera() {
        return null;
    }
}
