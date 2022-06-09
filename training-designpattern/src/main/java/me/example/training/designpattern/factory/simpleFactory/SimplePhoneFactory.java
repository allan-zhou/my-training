package me.example.training.designpattern.factory.simpleFactory;

import me.example.training.designpattern.factory.ApplePhone;
import me.example.training.designpattern.factory.IPhone;
import me.example.training.designpattern.factory.XiaoMiPhone;

/**
 * @author zhoujialiang9
 * @date 2022/6/9 4:45 PM
 **/
public class SimplePhoneFactory {
    /**
     * 简单工厂（静态工厂）
     * - 优化了客户端if/else
     *
     * @param money
     * @return
     */
     public static IPhone createPhone(Integer money) {
        if (money >= 5000) {
            return new ApplePhone();
        } else if (money >= 2000 && money < 5000) {
            return new XiaoMiPhone();
        } else {
            return null;
        }
    }

}
