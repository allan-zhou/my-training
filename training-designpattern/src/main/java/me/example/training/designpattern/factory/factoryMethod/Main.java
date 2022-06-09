package me.example.training.designpattern.factory.factoryMethod;

import me.example.training.designpattern.factory.IPhone;

/**
 * @author zhoujialiang9
 * @date 2022/6/9 4:55 PM
 **/
public class Main {

    public static void main(String[] args) {
        int myMoney = 3000;

        IPhoneFactory phoneFactory = new ApplePhoneFactory();
        IPhone phone = phoneFactory.createPhone(myMoney);

        phone.takePhotos();
        phone.takePhotos();

    }
}
