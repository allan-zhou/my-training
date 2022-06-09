package me.example.training.designpattern.factory.factoryMethod;

import lombok.extern.slf4j.Slf4j;
import me.example.training.designpattern.factory.ApplePhone;
import me.example.training.designpattern.factory.IPhone;

/**
 * @author zhoujialiang9
 * @date 2022/6/9 4:58 PM
 **/
@Slf4j
public class ApplePhoneFactory implements IPhoneFactory {

    int leastMoney = 5000;

    @Override
    public IPhone createPhone(Integer money) {
        if(money >= leastMoney) {
            return new ApplePhone();
        }

        log.info("买不起~~，至少需要 {}", leastMoney);

        return null;
    }
}
