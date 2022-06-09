package me.example.training.designpattern.factory.factoryMethod;

import me.example.training.designpattern.factory.IPhone;

/**
 * @author zhoujialiang9
 * @date 2022/6/9 4:56 PM
 **/
public interface IPhoneFactory {
    IPhone createPhone(Integer money);
}
