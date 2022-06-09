package me.example.training.designpattern.factory.abstractFactory;

import lombok.extern.slf4j.Slf4j;
import me.example.training.designpattern.factory.ApplePhone;
import me.example.training.designpattern.factory.IPhone;

/**
 * @author zhoujialiang9
 * @date 2022/6/9 5:26 PM
 **/
@Slf4j
public class AppleFactory extends AbstractFactory {

    int leastMoney = 5000;

    @Override
    IPhone createPhone(Integer money) {
        if(money > leastMoney) {
            return new ApplePhone();
        }

        log.info("钱不够啊，至少需要 {}", leastMoney);

        return null;
    }

    @Override
    ICamera createCamera() {
        return null;
    }
}
