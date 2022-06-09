package me.example.training.designpattern.factory.abstractFactory;

import me.example.training.designpattern.factory.IPhone;

/**
 * @author zhoujialiang9
 * @date 2022/6/9 5:22 PM
 **/
public class Main {
    public static void main(String[] args) {
        int myMoney = 3000;

        AppleFactory factory = new AppleFactory();

        IPhone phone = factory.createPhone(myMoney);
        ICamera camera = factory.createCamera();

    }
}
