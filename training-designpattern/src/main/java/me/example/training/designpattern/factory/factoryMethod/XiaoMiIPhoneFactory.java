package me.example.training.designpattern.factory.factoryMethod;

import lombok.extern.slf4j.Slf4j;
import me.example.training.designpattern.factory.IPhone;
import me.example.training.designpattern.factory.XiaoMiPhone;

/**
 * @author zhoujialiang9
 * @date 2022/6/9 4:56 PM
 **/
@Slf4j
public class XiaoMiIPhoneFactory implements IPhoneFactory {

    int leastMoney = 2000;

    @Override
    public IPhone createPhone(Integer money) {

        if(money >= leastMoney) {
            return new XiaoMiPhone();
        }

        log.info("买不起~~，至少需要 {}", leastMoney);

        return null;
    }
}
